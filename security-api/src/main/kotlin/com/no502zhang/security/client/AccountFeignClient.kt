package com.no502zhang.security.client

import com.no502zhang.security.dto.CreateAccountParam
import com.no502zhang.security.dto.CreateAccountResult
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient("SYSTEM")
interface AccountFeignClient {
    @PostMapping("/system/accounts")
    fun create(@RequestBody param: CreateAccountParam): CreateAccountResult
}