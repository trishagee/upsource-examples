package com.mechanitis.blog.upsource.social;

import java.util.List;

public class Controller {
    private static final Controller INSTANCE = new Controller();
    private List<TwitterUser> topTweeters;

    public void setTopTweeters(List<TwitterUser> topTweeters) {
        this.topTweeters = topTweeters;
    }

    public static Controller getController() {
        return INSTANCE;
    }
}
