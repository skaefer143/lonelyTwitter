package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Storm on 2016-09-27.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    /**
     * Instantiates a new Tweet list test.
     */
    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    /**
     * Test add tweet.
     */
    public void testAddTweet(){
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hello!");


        //checks to see if list has tweet
        assertFalse(list.hasTweet(tweet));
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));

        //checks to see if adding duplicate
        try {
            list.add(tweet);
            assertTrue(false);
        } catch(IllegalArgumentException e) {
            assertTrue(true);
        }

    }

    /**
     * Test has tweet.
     */
    public void testHasTweet() {
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hello!");
        Tweet otherTweet = new NormalTweet("Hey!");

        assertFalse(list.hasTweet(tweet));
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));

        list.add(otherTweet);
        assertFalse(list.hasTweet());
    }

    /**
     * Test get tweet.
     */
    public void testGetTweet() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi!");


        list.add(a);
        list.add(b);

        assertEquals(a, list.getTweet(0));
        assertEquals(b, list.getTweet(1));
    }

    /**
     * Test remove tweet.
     */
    public void testRemoveTweet() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");
        list.add(a);
        assertTrue(list.hasTweet(a));

        list.removeTweet(a);
        assertFalse(list.hasTweet(a));
    }

    /**
     * Test get tweets.
     */
    public void testGetTweets() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi!");
        Tweet c = new NormalTweet("Ola!");

        //adding it in order b, a, c
        list.add(b);
        list.add(a);
        list.add(c);

        List<Tweet> returnedList = list.getTweets();

        //if returnedList is not chronological
        //assert fails

        //checks to see if in correct order
        assertEquals(b, returnedList.get(0));
        assertEquals(a, returnedList.get(1));
        assertEquals(c, returnedList.get(2));

    }

    /**
     * Test get count.
     */
    public void testGetCount(){
        //checks to see if count is correct
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi!");
        Tweet c = new NormalTweet("Ola!");

        list.add(a);
        list.add(b);
        list.add(c);

        if (list.getCount() != 3){
            assertTrue(false);
        }
        else{
            assertTrue(true);
        }



    }
}


