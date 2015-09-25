package kz.kamadi.expo.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import kz.kamadi.expo.helper.FileHelper;

/**
 * Created by Madiyar on 21.09.2015.
 */
public class Event {

    private String time;

    private String title;

    private Drawable background;

    private String description;

    private String address;

    private double longitude;

    private double latitude;

    public Event(String time, String title, Drawable background, String description, String address, double longitude, double latitude) {
        this.time = time;
        this.title = title;
        this.background = background;
        this.description = description;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public static ArrayList<Event> getEvents(Context context) {
        ArrayList<Event> events = new ArrayList<>();
        String json = FileHelper.ReadFromfile(FileHelper.EVENT, context);
        Resources resources = context.getResources();
        int resourceId;
        try {
            JSONArray jsonArray = new JSONArray(json);
            JSONObject jsonObject;
            Event event;
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);

                resourceId = resources.getIdentifier(jsonObject.getString("background"), "drawable",
                        context.getPackageName());
                Drawable drawable = ContextCompat.getDrawable(context, resourceId);
                event = new Event(jsonObject.getString("time"), jsonObject.getString("title")
                        , drawable, jsonObject.getString("description"), jsonObject.getString("address"),
                        jsonObject.getDouble("longitude"),jsonObject.getDouble("latitude"));
                events.add(event);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return events;
    }

    public String getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public Drawable getBackground() {
        return background;
    }

    public String getDescription() {
        return description;
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
