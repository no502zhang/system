package com.no502zhang.user.service

import com.github.pagehelper.Page
import com.github.pagehelper.PageInfo
import com.no502zhang.user.model.User
import com.no502zhang.user.model.UserQueryVO
import com.no502zhang.user.model.UserUpdateVO

interface UserService {
    fun createUser(user: User): User

    fun updateUser(id: Int, user: UserUpdateVO): Boolean

    fun deleteUser(id: Int): Boolean

    fun getUser(id: Int): User?

    fun listUser(user: UserQueryVO, pageNum: Int, pageSize: Int): PageInfo<User?>
}