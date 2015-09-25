package kz.kamadi.expo.helper;

/**
 * Created by Madiyar on 23.09.2015.
 */

import android.content.Context;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Madiyar on 17.04.2015.
 */
public class FileHelper {


    public static final String MUSEUM = "museum.json";
    public static final String THEATER = "theaters.json";
    public static final String CINEMA = "cinemas.json";
    public static final String CLUB = "clubs.json";
    public static final String PHARMACY = "pharmacy.json";
    public static final String HOSPITAL = "hospitals.json";
    public static final String EVENT = "events.json";
    public static final String VISIT = "visit.json";

    private static String path = Environment.getExternalStorageDirectory() + "/Expo/";

    public static Boolean write(String fname, String fcontent) {
        try {
            File dir = new File(path);
            dir.mkdir();

            String fpath = path + fname + ".txt";

            File file = new File(fpath);

            // If file does not exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(fcontent);
            bw.close();


            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static String read(String fname) {

        BufferedReader br = null;
        String response = null;

        try {
            File dir = new File(path);
            dir.mkdir();

            StringBuffer output = new StringBuffer();
            String fpath = path + fname + ".json";
            File file = new File(fpath);

            // If file does not exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            br = new BufferedReader(new FileReader(fpath));
            String line = "";
            while ((line = br.readLine()) != null) {
                output.append(line + "\n");
            }
            response = output.toString();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;

        }
        return response;

    }

    public static String ReadFromfile(String fileName, Context context) {
        StringBuilder returnString = new StringBuilder();
        InputStream fIn = null;
        InputStreamReader isr = null;
        BufferedReader input = null;
        try {
            fIn = context.getResources().getAssets()
                    .open(fileName, Context.MODE_PRIVATE);
            isr = new InputStreamReader(fIn);
            input = new BufferedReader(isr);
            String line = "";
            while ((line = input.readLine()) != null) {
                returnString.append(line);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (isr != null)
                    isr.close();
                if (fIn != null)
                    fIn.close();
                if (input != null)
                    input.close();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        return returnString.toString();
    }

}
