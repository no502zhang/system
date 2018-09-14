package com.no502zhang.mail.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.web.bind.annotation.GetMapping

@RestController
@RequestMapping("/mail")
class MailController(val mailSender: JavaMailSender) {

    @GetMapping("/test")
    fun testMail(): ResponseEntity<Boolean> {
        val message = SimpleMailMessage()
        message.from = "no502zhang@163.com"
        message.setTo("no502zhang@163.com")
        message.subject = "测试"
        message.text = "测试"

        mailSender.send(message)

        return ResponseEntity.ok(true)
    }
}