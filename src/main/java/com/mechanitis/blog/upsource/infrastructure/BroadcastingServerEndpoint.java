package com.mechanitis.blog.upsource.infrastructure;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;

import static com.mechanitis.blog.upsource.infrastructure.MessageSender.sendMessageToClient;

public class BroadcastingServerEndpoint<T> extends Endpoint {
    private final List<Session> sessions = new ArrayList<>();

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        sessions.add(session);
    }

    public void onMessage(T message) {
        sessions.stream()
                .filter(Session::isOpen)
                .forEach(session -> sendMessageToClient(message.toString(), session));
    }
}
