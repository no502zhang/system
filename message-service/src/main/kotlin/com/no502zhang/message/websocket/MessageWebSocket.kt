package com.no502zhang.message.websocket

import javax.websocket.*
import javax.websocket.server.ServerEndpoint

@ServerEndpoint("/message/websocket")
class MessageWebSocket {

    var session: Session? = null

    @OnOpen
    fun onOpen(session: Session) {
        println("onOpen")
    }

    @OnClose
    fun onClose() {
        println("onClose")
    }

    @OnMessage
    fun onMessage(message: String, session: Session) {
        println("onMessage")
    }

    @OnError
    fun onError(session: Session, error: Throwable) {
        println("onError")
    }
}