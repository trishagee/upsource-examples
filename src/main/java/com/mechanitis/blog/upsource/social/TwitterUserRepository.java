package com.mechanitis.blog.upsource.social;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class TwitterUserRepository {
    private final List<TwitterUser> twitterUsers = new ArrayList<>();

    public void addTwitterUser(TwitterUser twitterUser) {
        twitterUsers.add(twitterUser);
    }

    public List<TwitterUser> getTwitterUsers() {
        twitterUsers.stream().sorted(comparing(TwitterUser::getTwitterHandle));

        return twitterUsers;
    }
}
