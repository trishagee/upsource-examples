package com.mechanitis.blog.upsource.infrastructure;

import com.mechanitis.blog.upsource.infrastructure.event.Event;
import com.mechanitis.blog.upsource.infrastructure.event.PostLoad;
import org.junit.Test;

public class EventInterceptorTest {
    @Test
    public void shouldCallSpecificEventInterceptorWithSubclass() {
        EventInterceptor eventInterceptor = new EventInterceptor();

        Event event = new PostLoad();

        eventInterceptor.interceptEvent(event, "String");
    }

}