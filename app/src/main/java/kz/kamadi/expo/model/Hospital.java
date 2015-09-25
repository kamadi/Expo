package kz.kamadi.expo.model;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import kz.kamadi.expo.helper.FileHelper;

/**
 * Created by Madiyar on 25.09.2015.
 */
public class Hospital {
    private int id;

    private String phone;

    private String fullName;

    private String street;

    private String building;

    private double latitude;

    private double longitude;

    private String manager;

    private String managerPosition;

    public Hospital(int id, String phone, String fullName, String street, String building, double latitude, double longitude, String manager, String managerPosition) {
        this.id = id;
        this.phone = phone;
        this.fullName = fullName;
        this.street = street;
        this.building = building;
        this.latitude = latitude;
        this.longitude = longitude;
        this.manager = manager;
        this.managerPosition = managerPosition;
    }

    public static ArrayList<Hospital> getHospitals(Context context) {
        ArrayList<Hospital> hospitals = new ArrayList<>();
        String json = FileHelper.ReadFromfile(FileHelper.HOSPITAL, context);
        try {
            JSONArray jsonArray = new JSONArray(json);
            JSONObject jsonObject;
            Pharmacy pharmacy;
            Hospital hospital;
            String[] geo;
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                geo = jsonObject.getString("Geoposition").split(",");
                hospital = new Hospital(jsonObject.getInt("ID"), jsonObject.getString("Phone"), jsonObject.getString("FullName"), jsonObject.getString("Street"), jsonObject.getString("Building")
                        , Double.parseDouble(geo[0]), Double.parseDouble(geo[1]), jsonObject.getString("ManagerName"), jsonObject.getString("ManagerPosition"));
                hospitals.add(hospital);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return hospitals;
    }

    public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getFullName() {
        return fullName;
    }

    public String getStreet() {
        return street;
    }

    public String getBuilding() {
        return building;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getManager() {
        return manager;
    }

    public String getManagerPosition() {
        return managerPosition;
    }


}
