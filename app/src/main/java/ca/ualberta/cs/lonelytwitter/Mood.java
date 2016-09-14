package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Storm on 2016-09-13.
 */
public abstract class Mood {
    private Date date;
    private String currentMood;
    private ArrayList<Mood> moods;

    public Mood(String currentMood){
        this.currentMood = currentMood;
        this.date = new Date();
    }

    public Mood(String currentMood, Date date){
        this.currentMood = currentMood;
        this.date = date;
    }

    public abstract String moodString();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCurrentMood() {
        return currentMood;
    }

    public void setCurrentMood(String currentMood) {
        this.currentMood = currentMood;
    }
}
