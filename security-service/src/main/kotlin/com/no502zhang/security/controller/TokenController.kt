package com.no502zhang.security.controller

import com.no502zhang.security.dto.CreateTokenParam
import com.no502zhang.security.dto.CreateTokenResult
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("tokens")
class TokenController {
    fun createToken(param: CreateTokenParam): CreateTokenResult {
        return CreateTokenResult()
    }
}