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

    /**
     * Instantiates a new Mood.
     *
     * @param currentMood the current mood
     */
    public Mood(String currentMood){
        this.currentMood = currentMood;
        this.date = new Date();
    }

    /**
     * Instantiates a new Mood.
     *
     * @param currentMood the current mood
     * @param date        the date
     */
    public Mood(String currentMood, Date date){
        this.currentMood = currentMood;
        this.date = date;
    }

    /**
     * Mood string string.
     *
     * @return the string
     */
    public abstract String moodString();

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets current mood.
     *
     * @return the current mood
     */
    public String getCurrentMood() {
        return currentMood;
    }

    /**
     * Sets current mood.
     *
     * @param currentMood the current mood
     */
    public void setCurrentMood(String currentMood) {
        this.currentMood = currentMood;
    }
}
