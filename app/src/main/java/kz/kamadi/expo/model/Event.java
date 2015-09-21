package kz.kamadi.expo.model;

/**
 * Created by Madiyar on 21.09.2015.
 */
public class Event {

    private long time;
    private String title;
    private String background;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
