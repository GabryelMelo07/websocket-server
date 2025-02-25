package com.websocket.server.utils;

import org.springframework.web.socket.WebSocketSession;

public class SessionInfoUtils {
    
    public static void printSessionInfo(WebSocketSession session) {
        SessionInfo sessionInfo = new SessionInfo(
            session.getId(),
            session.getUri().toString(),
            session.getPrincipal().getName(),
            session.getLocalAddress().toString(),
            session.getRemoteAddress().toString()
        );
        
        System.out.println(sessionInfo);
    }
    
}
