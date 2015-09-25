package kz.kamadi.expo.model;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import kz.kamadi.expo.helper.FileHelper;

/**
 * Created by Madiyar on 24.09.2015.
 */
public class Pharmacy {
    private int id;
    private String name;
    private String address;
    private double longitude;
    private double latitude;

    public Pharmacy(int id, String name, String address, double longtitude, double latitude) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.longitude = longtitude;
        this.latitude = latitude;
    }

    public static ArrayList<Pharmacy> getPharmacies(Context context) {
        ArrayList<Pharmacy> pharmacies = new ArrayList<>();
        String json = FileHelper.ReadFromfile(FileHelper.PHARMACY, context);
        try {
            JSONArray jsonArray = new JSONArray(json);
            JSONObject jsonObject;
            Pharmacy pharmacy;
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                pharmacy = new Pharmacy(jsonObject.getInt("Id"), jsonObject.getString("Name"), jsonObject.getString("Address")
                        , jsonObject.getDouble("Longitude"), jsonObject.getDouble("Latitude"));
                pharmacies.add(pharmacy);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return pharmacies;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
