package kz.kamadi.expo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import kz.kamadi.expo.R;
import kz.kamadi.expo.activity.MuseumActivity;

/**
 * Created by Madiyar on 21.09.2015.
 */
public class GuideFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guide, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.museum)
    void getMuseums() {
        startActivity(new Intent(getActivity(), MuseumActivity.class));
    }
}
