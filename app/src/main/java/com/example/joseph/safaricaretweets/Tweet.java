package com.example.joseph.safaricaretweets;

/**
 * Created by joseph on 2/26/18.
 */

public class Tweet {

    String tweetBy;
    String tweet;

    public Tweet(String tweetBy, String tweet) {
        this.tweetBy = tweetBy;
        this.tweet = tweet;
    }

    public String getTweetBy() {
        return tweetBy;
    }

    public void setTweetBy(String tweetBy) {
        this.tweetBy = tweetBy;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

}

