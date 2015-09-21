package kz.kamadi.expo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import kz.kamadi.expo.R;

/**
 * Created by Madiyar on 21.09.2015.
 */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventRecyclerViewHolder> {
    private LayoutInflater inflater;

    public EventAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public EventRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = inflater.inflate(R.layout.event_item, parent, false);
        EventRecyclerViewHolder holder = new EventRecyclerViewHolder(root);
        return holder;
    }

    @Override
    public void onBindViewHolder(EventRecyclerViewHolder holder, int position) {
        holder.titleView.setText("Certified products from campania".toUpperCase());
        holder.timeView.setText("12-00");
        if(position%2==0){
            holder.coverView.setBackgroundResource(R.drawable.image2);
        }else{
            holder.coverView.setBackgroundResource(R.drawable.image);
        }

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class EventRecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView titleView;
        TextView timeView;
        ImageView coverView;
        public EventRecyclerViewHolder(View itemView) {
            super(itemView);
            titleView = (TextView) itemView.findViewById(R.id.title);
            timeView = (TextView) itemView.findViewById(R.id.time);
            coverView = (ImageView) itemView.findViewById(R.id.cover_iv);

        }
    }
}
