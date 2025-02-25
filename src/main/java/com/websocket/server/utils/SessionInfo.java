package com.websocket.server.utils;

public record SessionInfo(String id, String uri, String principal, String localAddress, String remoteAddress) {
}
