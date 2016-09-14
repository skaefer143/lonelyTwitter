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
    }

    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
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
}
