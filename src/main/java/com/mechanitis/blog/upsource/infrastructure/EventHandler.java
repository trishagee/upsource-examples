package com.mechanitis.blog.upsource.infrastructure;

import com.mechanitis.blog.upsource.infrastructure.event.Event;

public class EventHandler {
    private Object entity;
    private EventInterceptor ei;

    public void handleEvent(Event event) {
        ei.interceptEvent(event, entity);
    }

}
