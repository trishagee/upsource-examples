package com.mechanitis.blog.upsource.infrastructure;

import com.mechanitis.blog.upsource.infrastructure.event.Event;
import com.mechanitis.blog.upsource.infrastructure.event.PostLoad;
import com.mechanitis.blog.upsource.infrastructure.event.PostPersist;
import com.mechanitis.blog.upsource.infrastructure.event.PreLoad;
import com.mechanitis.blog.upsource.infrastructure.event.PrePersist;
import com.mechanitis.blog.upsource.infrastructure.event.PreSave;

public class EventHandler {
    private Object entity;
    private EventInterceptor ei;

    public void handleEvent(Event event) {
        if (event instanceof PreLoad) {
            ei.preLoad(entity);
        } else if (event instanceof PostLoad) {
            ei.postLoad(entity);
        } else if (event instanceof PrePersist) {
            ei.prePersist(entity);
        } else if (event instanceof PreSave) {
            ei.preSave(entity);
        } else if (event instanceof PostPersist) {
            ei.postPersist(entity);
        }
    }

}
