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
import kz.kamadi.expo.model.Visit;

/**
 * Created by Madiyar on 21.09.2015.
 */
public class VisitAdapter extends RecyclerView.Adapter<VisitAdapter.VisitRecyclerViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<Visit> visits;
    private ItemAdapter.OnItemClickListener listener;

    public VisitAdapter(Context context, ArrayList<Visit> visits, ItemAdapter.OnItemClickListener listener) {
        this.visits = visits;
        this.listener = listener;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public VisitRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = inflater.inflate(R.layout.list_item_visit, parent, false);
        VisitRecyclerViewHolder holder = new VisitRecyclerViewHolder(root, listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(VisitRecyclerViewHolder holder, int position) {
        Visit visit = visits.get(position);
        holder.titleView.setText(visit.getName());
        holder.coverView.setBackground(visit.getImage());

    }

    @Override
    public int getItemCount() {
        return visits.size();
    }

    public static class VisitRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView titleView;
        ImageView coverView;

        private ItemAdapter.OnItemClickListener listener;

        public VisitRecyclerViewHolder(View itemView, ItemAdapter.OnItemClickListener listener) {
            super(itemView);
            this.listener = listener;
            titleView = (TextView) itemView.findViewById(R.id.title);
            coverView = (ImageView) itemView.findViewById(R.id.cover_iv);
            titleView.setOnClickListener(this);
            coverView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(v,getAdapterPosition());
        }
    }
}
