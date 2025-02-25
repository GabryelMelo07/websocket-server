package com.websocket.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.websocket.server.websocket.WebSocketSessionManager;

import java.io.IOException;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final WebSocketSessionManager sessionManager;

    public MessageController(WebSocketSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody MessageBody messageBody) {
        for (WebSocketSession session : sessionManager.getSessions()) {
            if (session.isOpen()) {
                try {
                    session.sendMessage(new TextMessage(messageBody.content()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return ResponseEntity.ok("Mensagem enviada com sucesso");
    }
    
}

