package com.no502zhang.user.controller

import com.github.pagehelper.PageInfo
import com.no502zhang.user.model.User
import com.no502zhang.user.model.UserQueryVO
import com.no502zhang.user.model.UserUpdateVO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController {
    @PostMapping("/")
    fun create(@RequestBody user: User): ResponseEntity<User> {

        return ResponseEntity.ok().body(user)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int): ResponseEntity<Boolean> {
        val flag = false
        return ResponseEntity.ok().body(flag)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Int,
               @RequestBody user: UserUpdateVO): ResponseEntity<Boolean> {
        val flag = false
        return ResponseEntity.ok().body(flag)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Int): ResponseEntity<User> {
        val user = User()
        return ResponseEntity.ok().body(user)
    }

    @GetMapping("/")
    fun list(user: UserQueryVO): ResponseEntity<PageInfo<User>> {

        return ResponseEntity.ok().body<PageInfo<User>>(null)
    }
}