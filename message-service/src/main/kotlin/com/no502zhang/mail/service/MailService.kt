package com.no502zhang.mail.service

import com.no502zhang.message.mail.dto.CreateMailParam
import com.no502zhang.message.mail.dto.CreateMailResult
import com.no502zhang.message.mail.dto.GetMailParam
import com.no502zhang.message.mail.dto.GetMailResult

interface MailService {
    fun getMail(id: String, param: GetMailParam): GetMailResult

    fun createMail(param: CreateMailParam): CreateMailResult
}