package com.no502zhang.user.client

import com.no502zhang.user.dto.*
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.*

@FeignClient("SYSTEM")
interface UserFeignClient {
    @PostMapping("/users")
    fun create(@RequestBody param: CreateUserParam): CreateUserResult

    @DeleteMapping("/users/{id}")
    fun delete(@PathVariable("id") id: String)

    @PutMapping("/users/{id}")
    fun update(@PathVariable("id") id: String,
               @RequestBody param: UpdateUserParam): UpdateUserResult

    @GetMapping("/users/{id}")
    fun get(@PathVariable("id") id: String): GetUserResult

    @GetMapping("/users/")
    fun list(@RequestParam(name = "name", required = false) name: String?,
             @RequestParam(name = "pageNum", required = false, defaultValue = "1") pageNum: Int,
             @RequestParam(name = "pageSize", required = false, defaultValue = "10") pageSize: Int): ListUserResult
}