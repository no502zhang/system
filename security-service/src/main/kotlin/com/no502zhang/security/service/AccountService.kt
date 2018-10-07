package com.no502zhang.security.service

import com.no502zhang.security.domain.Account
import com.no502zhang.security.dto.CreateAccountParam
import com.no502zhang.security.dto.CreateAccountResult
import com.no502zhang.security.repository.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountService(val accountRepository: AccountRepository) {
    fun createAccount(param: CreateAccountParam): CreateAccountResult {
        var account = Account(ownerId = param.ownerId, account = param.account)
        account.changePassword(param.password)
        accountRepository.save(account)
        return CreateAccountResult(account.id, account.account)
    }
}