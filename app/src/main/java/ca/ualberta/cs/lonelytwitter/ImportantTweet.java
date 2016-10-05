package ca.ualberta.cs.lonelytwitter;

/**
 * Created by Storm on 2016-09-13.
 */
public class ImportantTweet extends Tweet {
    /**
     * Instantiates a new Important tweet.
     *
     * @param message the message
     */
    public ImportantTweet(String message){
        super(message);
    }

    @Override //this lets us know this overrides something in the parent class
    public Boolean isImportant(){
        return Boolean.TRUE;
    }

}
