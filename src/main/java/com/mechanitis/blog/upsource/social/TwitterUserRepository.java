package com.mechanitis.blog.upsource.social;

import java.util.Set;
import java.util.TreeSet;

import static java.util.Comparator.comparing;

public class TwitterUserRepository {
    private final Set<TwitterUser> twitterUsers = new TreeSet<>(comparing(TwitterUser::getTwitterHandle));

    public void addTwitterUser(TwitterUser twitterUser) {
        twitterUsers.add(twitterUser);
    }

    public Set<TwitterUser> getTwitterUsers() {
        return twitterUsers;
    }
}
