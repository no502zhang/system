package com.no502zhang.security.service.impl

import com.no502zhang.security.domain.Token
import com.no502zhang.security.service.AccountService
import com.no502zhang.security.service.TokenService
import com.no502zhang.security.vo.AccountType
import org.springframework.stereotype.Service

@Service
class TokenServiceImpl(val accountService: AccountService) : TokenService {
    override fun createTokenByAccount(account: String, password: String): Token {
        val account = accountService.getAccountByTypeAndAccount(AccountType.ACCOUNT, account)
        if (account.checkPassword(password)) {
            return Token()
        } else {
            throw IllegalArgumentException()
        }
    }
}