package com.no502zhang.security.controller

import com.no502zhang.security.dto.CreateAccountParam
import com.no502zhang.security.dto.CreateAccountResult
import com.no502zhang.security.service.AccountService
import com.no502zhang.security.vo.AccountOwnerType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accounts")
class AccountController(val accountService: AccountService) {
    @PostMapping("")
    fun createAccount(@RequestBody param: CreateAccountParam): CreateAccountResult {
        when (param.ownerType) {
            AccountOwnerType.USER -> {
                val account = accountService.createUserAccount(param.ownerId, param.account, param.password
                        ?: throw java.lang.IllegalArgumentException())
                return CreateAccountResult(account.id, account.account)
            }
            else -> throw IllegalArgumentException()
        }

    }
}