package com.no502zhang.mail.controller

import com.no502zhang.mail.service.MailService
import com.no502zhang.message.mail.dto.CreateMailParam
import com.no502zhang.message.mail.dto.CreateMailResult
import com.no502zhang.message.mail.dto.GetMailParam
import com.no502zhang.message.mail.dto.GetMailResult
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/mails")
class MailController(val mailService: MailService) {

    @GetMapping("/{id}")
    fun getMail(@PathVariable("id") id: String, param: GetMailParam): GetMailResult {
        return mailService.getMail(id, param)
    }

    @PostMapping("")
    fun createMail(@RequestBody param: CreateMailParam): CreateMailResult {
        return mailService.createMail(param)
    }
}