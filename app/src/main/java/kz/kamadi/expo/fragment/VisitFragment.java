package kz.kamadi.expo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kz.kamadi.expo.activity.EvenInfoActivity;
import kz.kamadi.expo.activity.VisitActivity;
import kz.kamadi.expo.adapter.ItemAdapter;
import kz.kamadi.expo.adapter.VisitAdapter;
import kz.kamadi.expo.helper.SpacesItemDecoration;
import kz.kamadi.expo.model.Visit;

/**
 * Created by Madiyar on 21.09.2015.
 */
public class VisitFragment extends Fragment implements ItemAdapter.OnItemClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        RecyclerView gridView = new RecyclerView(getActivity());
        gridView.setHasFixedSize(true);
        gridView.setLayoutManager(layoutManager);
        ArrayList<Visit>visits = Visit.getVisits(getActivity());
        gridView.setAdapter(new VisitAdapter(getActivity(), visits, this));
        gridView.addItemDecoration(new SpacesItemDecoration(1));
        return gridView;
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(), VisitActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}
