package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Storm on 2016-09-13.
 */
public class HappyMood extends Mood{

    /**
     * Instantiates a new Happy mood.
     *
     * @param currentMood the current mood
     */
    public HappyMood(String currentMood){
        super(currentMood);
    }

    /**
     * Instantiates a new Happy mood.
     *
     * @param currentMood the current mood
     * @param date        the date
     */
    public HappyMood(String currentMood, Date date){
        super(currentMood, date);
    }

    @Override
    public String moodString(){
        return "I'm Happy!";
    }

}
