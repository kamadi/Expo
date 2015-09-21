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
public class VisitAdapter extends RecyclerView.Adapter<VisitAdapter.VisitRecyclerViewHolder> {
    private LayoutInflater inflater;

    public VisitAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public VisitRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = inflater.inflate(R.layout.visit_item, parent, false);
        VisitRecyclerViewHolder holder = new VisitRecyclerViewHolder(root);
        return holder;
    }

    @Override
    public void onBindViewHolder(VisitRecyclerViewHolder holder, int position) {
        holder.titleView.setText("Visit");

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

    public static class VisitRecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView titleView;
        TextView timeView;
        ImageView coverView;
        public VisitRecyclerViewHolder(View itemView) {
            super(itemView);
            titleView = (TextView) itemView.findViewById(R.id.title);
            timeView = (TextView) itemView.findViewById(R.id.time);
            coverView = (ImageView) itemView.findViewById(R.id.cover_iv);

        }
    }
}
