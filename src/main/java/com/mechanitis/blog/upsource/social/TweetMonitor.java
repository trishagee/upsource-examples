package com.mechanitis.blog.upsource.social;

import java.util.HashMap;
import java.util.Map;

public class TweetMonitor {
    private final Map<String, TwitterUser> allTwitterUsers = new HashMap<>();

    public TwitterUser getTwitterUser(String twitterHandle) {
        return allTwitterUsers.get(twitterHandle);
    }
}
