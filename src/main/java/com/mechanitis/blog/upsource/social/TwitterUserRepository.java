package com.mechanitis.blog.upsource.social;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TwitterUserRepository {
    private final List<TwitterUser> twitterUsers = new ArrayList<>();

    public void addTwitterUser(TwitterUser twitterUser) {
        twitterUsers.add(twitterUser);
    }

    public List<TwitterUser> getTwitterUsers() {
        Collections.sort(twitterUsers, new Comparator<TwitterUser>() {
            public int compare(TwitterUser o1, TwitterUser o2) {
                return o1.getTwitterHandle().compareTo(o2.getTwitterHandle());
            }
        });

        return twitterUsers;
    }
}
