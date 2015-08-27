package com.mechanitis.blog.upsource.social;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mechanitis.blog.upsource.social.Controller.getController;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class TweetMonitor implements MessageListener<String>, Drawable {
    private static final int LEADERBOARD_ROWS = 10;
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

    @Override
    public void draw() {
        List<TwitterUser> topTweeters =
                allTwitterUsers.values().stream()
                               .sorted(comparingInt(TwitterUser::getNumberOfTweets).reversed())
                               .limit(LEADERBOARD_ROWS)
                               .collect(toList());
        getController().setTopTweeters(topTweeters);
    }

}
