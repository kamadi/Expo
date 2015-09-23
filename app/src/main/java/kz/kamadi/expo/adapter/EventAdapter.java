package kz.kamadi.expo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import kz.kamadi.expo.R;
import kz.kamadi.expo.listener.OnItemClickListener;

/**
 * Created by Madiyar on 21.09.2015.
 */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventRecyclerViewHolder> {
    private LayoutInflater inflater;
    private OnItemClickListener listener;

    public EventAdapter(Context context, OnItemClickListener listener) {
        this.listener = listener;
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
        holder.titleView.setText("Certified products from campania".toUpperCase());
        holder.timeView.setText("12-00");
        if (position % 2 == 0) {
            holder.coverView.setBackgroundResource(R.drawable.image2);
        } else {
            holder.coverView.setBackgroundResource(R.drawable.image);
        }

    }

    @Override
    public int getItemCount() {
        return 10;
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
