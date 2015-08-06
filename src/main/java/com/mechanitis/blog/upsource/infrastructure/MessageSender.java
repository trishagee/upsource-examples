package com.mechanitis.blog.upsource.infrastructure;

import javax.websocket.Session;
import java.io.IOException;

public class MessageSender {
    static void sendMessageToClient(String message, Session session) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
