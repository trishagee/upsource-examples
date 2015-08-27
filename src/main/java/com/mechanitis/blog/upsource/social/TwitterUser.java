package com.mechanitis.blog.upsource.social;

public class TwitterUser {
    private String twitterHandle;

    public TwitterUser(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }

    public void addMessage(String tweet) {

    }

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public int getNumberOfTweets() {
        return 0;
    }
}
