package com.no502zhang.security.service.impl

import com.alibaba.fastjson.JSON
import com.no502zhang.security.service.AccountService
import com.no502zhang.security.service.TokenService
import com.no502zhang.security.vo.AccountType
import com.no502zhang.security.vo.Token
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.security.jwt.Jwt
import org.springframework.security.jwt.JwtHelper
import org.springframework.security.jwt.crypto.sign.MacSigner
import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.TimeUnit

@Service
class TokenServiceImpl(private val accountService: AccountService, private val stringRedisTemplate: StringRedisTemplate) : TokenService {

    @Value("\${jwt.secret:key}")
    lateinit var key: String

    @Value("\${jwt.ttl:3600000}")
    var ttl: Long = 3600000

    override fun createTokenByAccount(account: String, password: String): Jwt {
        val account = accountService.getAccountByTypeAndAccount(AccountType.ACCOUNT, account)
        if (account.checkPassword(password)) {
            // TODO 生成token
            // TODO 1. 使用账号对应的信息生成  subject
            val token = Token(exp = Date(System.currentTimeMillis() + ttl))
            // TODO 2. 根据配置的加密方式及秘钥生成  jwt
            val jwt = JwtHelper.encode(JSON.toJSONString(token), MacSigner(key))
            // 保存jwt到redis
            stringRedisTemplate.opsForValue().set(token.jti, jwt.encoded)
            stringRedisTemplate.expire(token.jti, ttl, TimeUnit.MILLISECONDS)

            return jwt
        } else {
            throw IllegalArgumentException()
        }
    }
}