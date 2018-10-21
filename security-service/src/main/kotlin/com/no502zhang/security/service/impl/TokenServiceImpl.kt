package com.no502zhang.security.service.impl

import com.alibaba.fastjson.JSON
import com.no502zhang.security.service.AccountService
import com.no502zhang.security.service.TokenService
import com.no502zhang.security.vo.AccountType
import com.no502zhang.security.vo.Token
import org.springframework.security.jwt.Jwt
import org.springframework.security.jwt.JwtHelper
import org.springframework.security.jwt.crypto.sign.MacSigner
import org.springframework.stereotype.Service
import java.util.*

@Service
class TokenServiceImpl(val accountService: AccountService) : TokenService {

    override fun createTokenByAccount(account: String, password: String): Jwt {
        val account = accountService.getAccountByTypeAndAccount(AccountType.ACCOUNT, account)
        if (account.checkPassword(password)) {
            // TODO 生成token
            // TODO 1. 使用账号对应的信息生成  subject
            val token = Token(exp = Date(System.currentTimeMillis() + 60 * 60 * 1000))
            // TODO 2. 根据配置的加密方式及秘钥生成  jwt
            return JwtHelper.encode(JSON.toJSONString(token), MacSigner("myKey"))
        } else {
            throw IllegalArgumentException()
        }
    }
}