package kz.kamadi.expo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kz.kamadi.expo.adapter.VisitAdapter;
import kz.kamadi.expo.helper.SpacesItemDecoration;

/**
 * Created by Madiyar on 21.09.2015.
 */
public class VisitFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        RecyclerView gridView = new RecyclerView(getActivity());
        gridView.setHasFixedSize(true);
        gridView.setLayoutManager(layoutManager);
        gridView.setAdapter(new VisitAdapter(getActivity()));
        gridView.addItemDecoration(new SpacesItemDecoration(1));
        return gridView;
    }
}
