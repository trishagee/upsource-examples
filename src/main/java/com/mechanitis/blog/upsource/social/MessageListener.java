package com.mechanitis.blog.upsource.social;

public interface MessageListener<T> {
    void onMessage(String username, T message);

}
