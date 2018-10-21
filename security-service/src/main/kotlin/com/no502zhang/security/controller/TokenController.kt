package com.no502zhang.security.controller

import com.alibaba.fastjson.JSON
import com.no502zhang.security.dto.CreateTokenParam
import com.no502zhang.security.dto.CreateTokenResult
import com.no502zhang.security.dto.UpdateTokenParam
import com.no502zhang.security.dto.UpdateTokenResult
import com.no502zhang.security.service.TokenService
import com.no502zhang.security.vo.AccountType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tokens")
class TokenController(val tokenService: TokenService) {
    @PostMapping("")
    fun createToken(@RequestBody param: CreateTokenParam): CreateTokenResult {
        when (param.accountType) {
            AccountType.ACCOUNT -> {
                val jwt = tokenService.createTokenByAccount(param.account,
                        param.password ?: throw IllegalArgumentException())
                return CreateTokenResult(token = jwt.encoded, expires = JSON.parseObject(jwt.claims).getDate("exp"))
            }
            else -> throw IllegalArgumentException()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteToken(@PathVariable("id") id: String) {

    }

    @PutMapping("/{id}")
    fun updateToken(@PathVariable("id") id: String, @RequestBody param: UpdateTokenParam): UpdateTokenResult {
        return UpdateTokenResult()
    }
}