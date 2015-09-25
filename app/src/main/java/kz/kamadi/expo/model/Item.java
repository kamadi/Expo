package kz.kamadi.expo.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import kz.kamadi.expo.R;
import kz.kamadi.expo.helper.FileHelper;

/**
 * Created by Madiyar on 23.09.2015.
 */
public class Item {
    public static final int MUSEUM = 1;
    public static final int CINEMA = 2;
    public static final int THEATER = 3;
    public static final int CLUB = 4;
    public static final String ID = "ID";
    public static final String FULL_NAME = "FullName";
    public static final String STREET = "Street";
    public static final String BUILDING = "Building";
    public static final String PHONE = "Phone";
    public static final String WEBSITE = "Website";
    public static final String GEOPOSITION = "Geoposition";
    public static final String IMAGE = "Image";
    public static final String DESCRIPTION = "Description";

    public static Item item;
    public static int currentItem;

    protected int id;

    protected Drawable image;

    protected String website;

    protected String phone;

    protected String fullName;

    protected String street;

    protected String building;

    protected String description;

    protected double latitude;

    protected double longitude;


    private Item(int id, Drawable image, String website, String phone, String fullName, String street,
                 String building, String description, double latitude, double longitude) {
        this.id = id;
        this.image = image;
        this.website = website;
        this.phone = phone;
        this.fullName = fullName;
        this.street = street;
        this.building = building;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private Item() {

    }


    public static Item createInstance(int current) {
        if (item == null) {
            item = new Item();
        }
        currentItem = current;
        return item;
    }

    public static Item getInstance() {
        if (item == null) {
            item = new Item();
        }
        return item;
    }

    public int getCurrentItem() {
        return currentItem;
    }

    public String getCurrentTitle(Context context) {
        switch (currentItem) {
            case Item.MUSEUM:
                return context.getString(R.string.museums);
            case Item.THEATER:
                return context.getString(R.string.theaters);
            case Item.CINEMA:
                return context.getString(R.string.cinemas);
            case Item.CLUB:
                return context.getString(R.string.clubs);
        }

        return "";
    }

    public ArrayList<Item> getItems(Context context) {
        String fileName = "";
        switch (currentItem) {
            case MUSEUM:
                fileName = FileHelper.MUSEUM;
                break;
            case CINEMA:
                fileName = FileHelper.CINEMA;
                break;

            case THEATER:
                fileName = FileHelper.THEATER;
                break;
            case CLUB:
                fileName = FileHelper.CLUB;
                break;
        }
        String json = FileHelper.ReadFromfile(fileName, context);
        Resources resources = context.getResources();
        int resourceId;
        ArrayList<Item> items = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            JSONObject jsonObject;
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                resourceId = resources.getIdentifier(jsonObject.getString(IMAGE), "drawable",
                        context.getPackageName());
                Drawable drawable = ContextCompat.getDrawable(context, resourceId);
                Item item = new Item(Integer.parseInt(jsonObject.getString(ID)), drawable, jsonObject.getString(WEBSITE),
                        jsonObject.getString(PHONE), jsonObject.getString(FULL_NAME), jsonObject.getString(STREET), jsonObject.getString(BUILDING),
                        jsonObject.getString(DESCRIPTION), Double.parseDouble(jsonObject.getString(GEOPOSITION).split(",")[0]),
                        Double.parseDouble(jsonObject.getString(GEOPOSITION).split(",")[1]));
                items.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
