package com.no502zhang.security.service

import com.no502zhang.security.domain.Token

interface TokenService {
    fun createTokenByAccount(account: String, password: String): Token
}