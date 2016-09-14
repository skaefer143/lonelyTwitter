package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Storm on 2016-09-13.
 */
public class HappyMood extends Mood{

    public HappyMood(String currentMood){
        super(currentMood);
    }

    public HappyMood(String currentMood, Date date){
        super(currentMood, date);
    }

    @Override
    public String moodString(){
        return "I'm Happy!";
    }

}
