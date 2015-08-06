package com.mechanitis.blog.upsource.infrastructure;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.mechanitis.blog.upsource.infrastructure.MessageSender.sendMessageToClient;

public class BroadcastingServerEndpoint<T> extends Endpoint {
    private static final Logger LOGGER = Logger.getLogger(BroadcastingServerEndpoint.class.getName());

    private final List<Session> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        sessions.add(session);
    }

    public void onMessage(T message) {
        if (LOGGER.isLoggable(Level.FINEST)) {
            LOGGER.log(Level.FINEST, String.format("Received message %s", message));
        }
        sessions.stream()
                .filter(Session::isOpen)
                .forEach(session -> sendMessageToClient(message.toString(), session));
    }
}
