package kz.kamadi.expo.model;

/**
 * Created by Madiyar on 23.09.2015.
 */
public class Item {

    public static final String ID = "ID";
    public static final String FULL_NAME = "FullName";
    public static final String STREET = "FullName";
    public static final String BUILDING = "FullName";
    public static final String PHONE = "FullName";
    public static final String WEBSITE = "FullName";
    public static final String IMAGE = "image";
    public static final String DESCRIPTION = "description";
    protected int id;

    protected String image;

    protected String website;

    protected String phone;

    protected String fullName;

    protected String street;

    protected String building;

    protected String description;

    protected double latitude;

    protected double longitude;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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
