package com.mechanitis.blog.upsource.social;

import java.util.HashMap;
import java.util.Map;

public class TweetMonitor implements MessageListener<String> {
    private final Map<String, TwitterUser> allTwitterUsers = new HashMap<>();

    @Override
    public void onMessage(String twitterHandle, String fullTweetJson) {
        TwitterUser twitterUser = allTwitterUsers.computeIfAbsent(twitterHandle, TwitterUser::new);
        twitterUser.addMessage(getTweetMessageFromFullTweet(fullTweetJson));
    }

    private String getTweetMessageFromFullTweet(String fullTweetJson) {
        String textFieldName = "\"text\":\"";
        String nextFieldName = "\",\"source\":\"";
        int indexOfTextField = fullTweetJson.indexOf(textFieldName) + textFieldName.length();
        int indexOfEndOfText = fullTweetJson.indexOf(nextFieldName);
        return fullTweetJson.substring(indexOfTextField, indexOfEndOfText);
    }
}
