package com.mechanitis.blog.upsource.browser;

import org.junit.Assert;
import org.junit.Test;

import java.net.URI;

import static org.hamcrest.core.Is.is;

public class UserTest {
//    @Test
//    public void shouldGetFirstHistory() {
//        User user = new User();
//
//        URI first = URI.create("www.thefirstone.com");
//        URI second = URI.create("www.thesecondone.com");
//
//        user.visited(first);
//        user.visited(second);
//        user.visited(first);
//
//        Assert.assertThat(user.getFirstVisited(), is(first));
//    }

    @Test
    public void shouldGetLastHistory() {
        User user = new User();

        URI first = URI.create("www.thefirstone.com");
        URI second = URI.create("www.thesecondone.com");

        user.visited(first);
        user.visited(second);
        user.visited(first);

        Assert.assertThat(user.getLastVisited(), is(first));
    }
}