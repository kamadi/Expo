package kz.kamadi.expo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kz.kamadi.expo.activity.EvenInfoActivity;
import kz.kamadi.expo.adapter.EventAdapter;
import kz.kamadi.expo.helper.SimpleDividerItemDecoration;
import kz.kamadi.expo.listener.OnItemClickListener;

/**
 * Created by Madiyar on 21.09.2015.
 */
public class EventFragment extends Fragment implements OnItemClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = new RecyclerView(getActivity());
        recyclerView.setAdapter(new EventAdapter(getActivity(), this));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
        return recyclerView;
    }

    @Override
    public void onItemClick(View view, int position) {
        startActivity(new Intent(getActivity(), EvenInfoActivity.class));
    }
}
