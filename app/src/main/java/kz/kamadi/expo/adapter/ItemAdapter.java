package kz.kamadi.expo.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import kz.kamadi.expo.R;
import kz.kamadi.expo.model.Item;

/**
 * Created by Madiyar on 23.09.2015.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemRecyclerViewHolder> {


    private final Resources resources;
    public OnItemClickListener listener;
    public List<Item> items;
    private LayoutInflater inflater;
    private Context context;

    public ItemAdapter(Context context, ArrayList<Item> items, OnItemClickListener listener) {
        inflater = LayoutInflater.from(context);
        this.listener = listener;
        this.items = items;
        this.context = context;
        resources = context.getResources();
    }

    @Override
    public ItemRecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View root = inflater.inflate(R.layout.list_item_museum, viewGroup, false);
        ItemRecyclerViewHolder holder = new ItemRecyclerViewHolder(root, listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemRecyclerViewHolder itemRecyclerViewHolder, int i) {
        Item item = items.get(i);
        itemRecyclerViewHolder.title.setText(item.getFullName());
        itemRecyclerViewHolder.description.setText(item.getDescription());

        final int resourceId = resources.getIdentifier(item.getImage(), "drawable",
                context.getPackageName());
        itemRecyclerViewHolder.thumbnail.setImageDrawable(ContextCompat.getDrawable(context, resourceId));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public static class ItemRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        OnItemClickListener listener;

        @Bind(R.id.title)
        TextView title;

        @Bind(R.id.description)
        TextView description;

        @Bind(R.id.thumbnail)
        ImageView thumbnail;

        public ItemRecyclerViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.listener = listener;
            title.setOnClickListener(this);
            description.setOnClickListener(this);
            thumbnail.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            listener.onItemClick(v, getAdapterPosition());
        }
    }
}
