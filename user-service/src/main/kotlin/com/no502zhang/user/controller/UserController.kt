package com.no502zhang.user.controller

import com.github.pagehelper.PageInfo
import com.no502zhang.user.model.User
import com.no502zhang.user.model.UserQueryVO
import com.no502zhang.user.model.UserUpdateVO
import com.no502zhang.user.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(val userService: UserService) {
    @PostMapping("/")
    fun create(@RequestBody user: User): ResponseEntity<User> {
        userService.createUser(user)
        return ResponseEntity.ok().body(user)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int): ResponseEntity<Boolean> {
        val flag = false
        userService.deleteUser(id)
        return ResponseEntity.ok().body(flag)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Int,
               @RequestBody user: UserUpdateVO): ResponseEntity<Boolean> {
        val flag = false
        userService.updateUser(id, user)
        return ResponseEntity.ok().body(flag)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Int): ResponseEntity<User> {
        val user = userService.getUser(id)
        return ResponseEntity.ok().body(user)
    }

    @GetMapping("/")
    fun list(user: UserQueryVO, @RequestParam(name = "pageNum", required = false, defaultValue = "1") pageNum: Int,
             @RequestParam(name = "pageSize", required = false, defaultValue = "10") pageSize: Int): ResponseEntity<PageInfo<User>> {
        val result = userService.listUser(user, pageNum, pageSize)
        return ResponseEntity.ok().body<PageInfo<User>>(result)
    }
}