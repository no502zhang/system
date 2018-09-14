package com.no502zhang.user.client

import com.github.pagehelper.PageInfo
import com.no502zhang.user.model.User
import com.no502zhang.user.model.UserQueryVO
import com.no502zhang.user.model.UserUpdateVO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.*

@FeignClient("SYSTEM")
interface UserClient {
    @PostMapping("/users/")
    fun create(@RequestBody user: User): User

    @DeleteMapping("/users/{id}")
    fun delete(@PathVariable("id") id: Int): Boolean

    @PutMapping("/users/{id}")
    fun update(@PathVariable("id") id: Int,
               @RequestBody user: UserUpdateVO): Boolean

    @GetMapping("/users/{id}")
    fun get(@PathVariable("id") id: Int): User

    @GetMapping("/users/")
    fun list(user: UserQueryVO, @RequestParam(name = "pageNum", required = false, defaultValue = "1") pageNum: Int,
             @RequestParam(name = "pageSize", required = false, defaultValue = "10") pageSize: Int): PageInfo<User>
}