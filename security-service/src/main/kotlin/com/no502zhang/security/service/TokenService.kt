package com.no502zhang.security.service

import org.springframework.security.jwt.Jwt

interface TokenService {
    fun createTokenByAccount(account: String, password: String): Jwt
}