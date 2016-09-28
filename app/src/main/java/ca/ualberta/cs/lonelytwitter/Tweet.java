package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Storm on 2016-09-13.
 */
public abstract class Tweet {
    private String message;
    private Date date;
    //protected means a child class can access the variable if it's in the parent class
    //private means only stuff in this class can use the string message
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    public abstract Boolean isImportant();
    //abstract means it forces all children to have this method


    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            //Do something
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }

    public boolean equals(Tweet tweet){
        // checks to see if all variables of both Tweets are the same (message and date)
        if (message.equals(tweet.message)){
            if (date.equals(tweet.getDate())){
                return true;
            }
        }
        return false;

    }
}
