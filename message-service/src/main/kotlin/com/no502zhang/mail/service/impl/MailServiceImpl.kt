package com.no502zhang.mail.service.impl

import com.no502zhang.mail.service.MailService
import com.no502zhang.message.mail.dto.CreateMailParam
import com.no502zhang.message.mail.dto.CreateMailResult
import com.no502zhang.message.mail.dto.GetMailParam
import com.no502zhang.message.mail.dto.GetMailResult
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service
import java.util.*

@Service
class MailServiceImpl(val mailSender: JavaMailSender) : MailService {

    @Value("\${spring.mail.username}")
    lateinit var systemMailAddress: String

    override fun getMail(id: String, param: GetMailParam): GetMailResult {
        return GetMailResult(UUID.randomUUID().toString(), "ok")
    }

    override fun createMail(param: CreateMailParam): CreateMailResult {
        val message = SimpleMailMessage()
        message.from = systemMailAddress
        message.setTo(param.mailTo)
        message.subject = param.title
        message.text = param.content

        mailSender.send(message)

        return CreateMailResult(UUID.randomUUID().toString(), "ok")
    }
}