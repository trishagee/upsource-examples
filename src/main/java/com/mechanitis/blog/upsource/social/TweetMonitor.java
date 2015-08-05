package com.mechanitis.blog.upsource.social;

import java.util.HashMap;
import java.util.Map;

public class TweetMonitor {
    private final Map<String, TwitterUser> allTwitterUsers = new HashMap<>();

    public void onMessage(String twitterHandle, String tweet) {
        TwitterUser twitterUser = allTwitterUsers.computeIfAbsent(twitterHandle, TwitterUser::new);
        twitterUser.addMessage(tweet);
    }

    public TwitterUser getTwitterUser(String twitterHandle) {
        return allTwitterUsers.get(twitterHandle);
    }
}
