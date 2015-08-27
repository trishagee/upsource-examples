package com.mechanitis.blog.upsource.infrastructure;

import com.mechanitis.blog.upsource.infrastructure.event.Event;
import com.mechanitis.blog.upsource.infrastructure.event.PostLoad;
import com.mechanitis.blog.upsource.infrastructure.event.PostPersist;
import com.mechanitis.blog.upsource.infrastructure.event.PreLoad;
import com.mechanitis.blog.upsource.infrastructure.event.PrePersist;
import com.mechanitis.blog.upsource.infrastructure.event.PreSave;

public class EventInterceptor {
    public void interceptEvent(PreLoad event, Object entity) {
        //do pre-load stuff here
    }

    public void interceptEvent(PostLoad event, Object entity) {
        //do post-load stuff here
    }

    public void interceptEvent(PrePersist event, Object entity) {
        //do pre-persist stuff here
    }

    public void interceptEvent(PreSave event, Object entity) {
        //do pre-save stuff here
    }

    public void interceptEvent(PostPersist event, Object entity) {
        //do post-persist stuff here
    }

    public void interceptEvent(Event event, Object entity) {
        //do some general handling here for other events
    }
}
