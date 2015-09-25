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
 * Created by Bakhtiyar on 25.09.2015.
 */
public class Visit {

    private int Id;
    private String name;
    private String description;
    private Drawable image;
    private String category;

    public Visit(int id, String name, String description, Drawable image, String category) {
        Id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.category = category;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static ArrayList<Visit> getVisits(Context context) {
        ArrayList<Visit> visits = new ArrayList<>();
        String json = FileHelper.ReadFromfile(FileHelper.VISIT, context);

        Resources resources = context.getResources();
        int resourceId;

        try {
            JSONArray jsonArray = new JSONArray(json);
            JSONObject jsonObject;
            Visit visit;
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                resourceId = resources.getIdentifier(jsonObject.getString("Image"), "drawable",
                        context.getPackageName());
                Drawable drawable = ContextCompat.getDrawable(context, resourceId);
                visit = new Visit(jsonObject.getInt("ID"), jsonObject.getString("Name"),
                        jsonObject.getString("Description"), drawable, jsonObject.getString("Category"));
                visits.add(visit);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return visits;
    }
}
