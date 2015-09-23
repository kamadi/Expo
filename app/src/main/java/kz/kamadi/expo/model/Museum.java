package kz.kamadi.expo.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import kz.kamadi.expo.helper.FileHelper;

/**
 * Created by Madiyar on 23.09.2015.
 */
public class Museum extends Item {

    private static final String LOG_TAG = "Museum";
    private static ArrayList<Museum> museums;

    private static Museum museum;

    public static Museum getInstance() {
        if (museum == null) {
            museum = new Museum();
            museums = new ArrayList<>();
        }
        return museum;
    }

    public ArrayList<Museum> getMuseums() {
        if (museums.isEmpty()) {
            museums = fetchMuseums();
        }
        return museums;
    }

    private ArrayList<Museum> fetchMuseums() {
        String json = FileHelper.read(FileHelper.MUSEUM);
        Log.e(LOG_TAG, json);
        try {
            JSONArray jsonArray = new JSONArray(json);
            JSONObject jsonObject;
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                Museum museum = new Museum();
                museum.setId(Integer.parseInt(jsonObject.getString(ID)));
                museum.setFullName(jsonObject.getString(FULL_NAME));
                museum.setDescription(jsonObject.getString(DESCRIPTION));
                museum.setImage(jsonObject.getString(IMAGE));
                museums.add(museum);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return museums;
    }
}
