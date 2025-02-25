package com.websocket.server.utils;

import org.springframework.web.socket.WebSocketSession;

public class SessionInfoUtils {

    public static void printSessionInfo(WebSocketSession session) {
        String principalName = (session.getPrincipal() != null) ? session.getPrincipal().getName() : null;

        SessionInfo sessionInfo = new SessionInfo(
            session.getId(),
            (session.getUri() != null) ? session.getUri().toString() : null,
            principalName,
            (session.getLocalAddress() != null) ? session.getLocalAddress().toString() : null,
            (session.getRemoteAddress() != null) ? session.getRemoteAddress().toString() : null
        );

        System.out.println(sessionInfo);
    }

}
