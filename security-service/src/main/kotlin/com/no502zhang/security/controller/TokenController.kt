package com.no502zhang.security.controller

import com.no502zhang.security.dto.CreateTokenParam
import com.no502zhang.security.dto.CreateTokenResult
import com.no502zhang.security.dto.UpdateTokenParam
import com.no502zhang.security.dto.UpdateTokenResult
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tokens")
class TokenController {
    @PostMapping("")
    fun createToken(@RequestBody param: CreateTokenParam): CreateTokenResult {
        return CreateTokenResult("test")
    }

    @DeleteMapping("/{id}")
    fun deleteToken(@PathVariable("id") id: String) {

    }

    @PutMapping("/{id}")
    fun updateToken(@PathVariable("id") id: String, @RequestBody param: UpdateTokenParam): UpdateTokenResult {
        return UpdateTokenResult()
    }
}