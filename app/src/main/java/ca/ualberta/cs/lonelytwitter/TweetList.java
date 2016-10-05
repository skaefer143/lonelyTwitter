package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Storm on 2016-09-27.
 */
public class TweetList {

    /**
     * The Tweets.
     */
    List<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * Add.
     *
     * @param tweet the tweet
     */
    public void add(Tweet tweet) {
        //if the list of tweets contains the tweet we're trying to add, throw an exception
        if(tweets.contains(tweet)){
            throw new IllegalArgumentException();
        }
        else {
            tweets.add(tweet);
        }
    }

    /**
     * Has tweet boolean.
     *
     * @return the boolean
     */
    public boolean hasTweet(){
        //checks itself to see if it contains the same duplicate tweet (same message and date)
        for (int i = 0; i < tweets.size(); i++){
            for (int j = 0; j < tweets.size(); j++){
                if (i != j){
                    if (tweets.get(i).equals(tweets.get(j))){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Has tweet boolean.
     *
     * @param tweet the tweet
     * @return the boolean
     */
    public boolean hasTweet(Tweet tweet){
        //checks to see if inputted tweet is in the tweet list
        return tweets.contains(tweet);
    }

    /**
     * Get tweet tweet.
     *
     * @param i the
     * @return the tweet
     */
    public Tweet getTweet(int i){
        //returns the tweet at position i
        return tweets.get(i);
    }

    /**
     * Remove tweet.
     *
     * @param a the a
     */
    public void removeTweet(Tweet a) {
        //removes the a tweet
        tweets.remove(a);
    }

    /**
     * Get count int.
     *
     * @return the int
     */
    public int getCount(){
        //returns the size of the tweet list
        return tweets.size();
    }

    /**
     * Gets tweets.
     *
     * @return the tweets
     */
    public List<Tweet> getTweets() {
        //returns the sorted by date version of the tweet list
        List<Tweet> copy = new ArrayList<Tweet>(tweets);
        Collections.sort(copy, new Comparator<Tweet>() {
            public int compare(Tweet o1, Tweet o2) {
                if (o1.getDate().before(o2.getDate())) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        return copy;
    }
}
