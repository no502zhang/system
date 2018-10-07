package com.no502zhang.security.controller

import com.no502zhang.security.dto.CreateAccountParam
import com.no502zhang.security.dto.CreateAccountResult
import com.no502zhang.security.service.AccountService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accounts")
class AccountController(val accountService: AccountService) {
    @PostMapping("")
    fun createToken(@RequestBody param: CreateAccountParam): CreateAccountResult {
        return accountService.createAccount(param)
    }
}