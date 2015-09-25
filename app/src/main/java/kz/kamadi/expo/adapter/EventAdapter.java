package kz.kamadi.expo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import kz.kamadi.expo.R;
import kz.kamadi.expo.listener.OnItemClickListener;
import kz.kamadi.expo.model.Event;

/**
 * Created by Madiyar on 21.09.2015.
 */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventRecyclerViewHolder> {
    private LayoutInflater inflater;
    private OnItemClickListener listener;
    private ArrayList<Event> events;

    public EventAdapter(Context context, OnItemClickListener listener, ArrayList<Event> events) {
        this.listener = listener;
        this.events = events;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public EventRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = inflater.inflate(R.layout.list_item_event, parent, false);
        EventRecyclerViewHolder holder = new EventRecyclerViewHolder(root, listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(EventRecyclerViewHolder holder, int position) {
        Event event = events.get(position);
        holder.titleView.setText(event.getTitle().toUpperCase());
        holder.timeView.setText(event.getTime());
        holder.coverView.setBackground(event.getBackground());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public static class EventRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView titleView;
        TextView timeView;
        ImageView coverView;
        private OnItemClickListener listener;

        public EventRecyclerViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            this.listener = listener;
            titleView = (TextView) itemView.findViewById(R.id.title);
            timeView = (TextView) itemView.findViewById(R.id.time);
            coverView = (ImageView) itemView.findViewById(R.id.cover_iv);
            titleView.setOnClickListener(this);
            timeView.setOnClickListener(this);
            coverView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(v, getAdapterPosition());
        }
    }
}
