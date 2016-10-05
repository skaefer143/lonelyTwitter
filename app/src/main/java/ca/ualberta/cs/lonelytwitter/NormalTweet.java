package ca.ualberta.cs.lonelytwitter;

/**
 * Created by Storm on 2016-09-13.
 */
public class NormalTweet extends Tweet implements Tweetable{

    /**
     * Instantiates a new Normal tweet.
     *
     * @param message the message
     */
    public NormalTweet(String message){
        super(message);
    }

    @Override
    public Boolean isImportant(){
        return Boolean.FALSE;
    }
}
