package kz.kamadi.expo.fragment;

import android.app.Activity;
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
import kz.kamadi.expo.activity.EmergencyActivity;
import kz.kamadi.expo.activity.HospitalActivity;
import kz.kamadi.expo.activity.ItemActivity;
import kz.kamadi.expo.activity.PharmacyActivity;
import kz.kamadi.expo.model.Item;

/**
 * Created by Madiyar on 21.09.2015.
 */
public class GuideFragment extends Fragment {

    Intent intent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guide, container, false);
        ButterKnife.bind(this, view);
        intent = new Intent(getActivity(), ItemActivity.class);
        return view;
    }

    @OnClick(R.id.museum)
    void getMuseums() {
        Item.createInstance(Item.MUSEUM);
        startActivity(intent);
    }

    @OnClick(R.id.cinema)
    void getCinemas() {
        Item.createInstance(Item.CINEMA);
        startActivity(intent);
    }

    @OnClick(R.id.theater)
    void getTheaters() {
        Item.createInstance(Item.THEATER);
        startActivity(intent);
    }

    @OnClick(R.id.club)
    void getClubs() {
        Item.createInstance(Item.THEATER);
        startActivity(intent);
    }

    @OnClick(R.id.pharmacy)
    void getPharmacy() {
        startActivity(new Intent(getActivity(), PharmacyActivity.class));
    }

    @OnClick(R.id.hospital)
    void getHospital() {
        startActivity(new Intent(getActivity(), HospitalActivity.class));
    }

    @OnClick(R.id.emergency)
    void getEmergency(){
        startActivity(new Intent(getActivity(), EmergencyActivity.class));
    }


}
