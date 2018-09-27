package com.no502zhang.user.controller

import com.no502zhang.user.dto.*
import com.no502zhang.user.service.UserService
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.*

@Api(value = "UserController", description = "用户信息接口")
@RestController
@RequestMapping("/users")
class UserController(val userService: UserService) {
    @PostMapping("")
    fun create(@RequestBody param: CreateUserParam): CreateUserResult {
        return userService.createUser(param)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: String) {
        userService.deleteUser(id)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: String,
               @RequestBody param: UpdateUserParam): UpdateUserResult {
        return userService.updateUser(id, param)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: String, param: GetUserParam): GetUserResult {
        return userService.getUser(id, param)
    }

    @GetMapping("")
    fun list(param: ListUserParam): ListUserResult {
        return userService.listUser(param)
    }
}