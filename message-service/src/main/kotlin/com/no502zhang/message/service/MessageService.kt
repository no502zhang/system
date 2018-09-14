package com.no502zhang.message.service

import com.no502zhang.message.websocket.MessageWebSocket
import org.springframework.stereotype.Service
import java.util.concurrent.CopyOnWriteArraySet

@Service
class MessageService {
    var webSocketSet = CopyOnWriteArraySet<MessageWebSocket>()
}