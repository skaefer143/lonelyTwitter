package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Storm on 2016-09-13.
 */
public class SadMood extends Mood {

    /**
     * Instantiates a new Sad mood.
     *
     * @param currentMood the current mood
     */
    public SadMood(String currentMood){
        super(currentMood);
    }

    /**
     * Instantiates a new Sad mood.
     *
     * @param currentMood the current mood
     * @param date        the date
     */
    public SadMood(String currentMood, Date date){
        super(currentMood, date);
    }

    @Override
    public String moodString(){
        return "I'm Sad!";
    }
}
