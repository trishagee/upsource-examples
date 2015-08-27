package com.mechanitis.blog.upsource.infrastructure;

import com.mechanitis.blog.upsource.infrastructure.event.PostPersist;
import org.junit.Test;

public class EventHandlerTest {
    @Test
    public void shouldCoverage() {
        EventHandler eventHandler = new EventHandler();
        eventHandler.handleEvent(new PostPersist());
    }

}