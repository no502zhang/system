package com.no502zhang.user.service

import com.github.pagehelper.Page
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.no502zhang.user.mapper.UserMapper
import com.no502zhang.user.model.User
import com.no502zhang.user.model.UserQueryVO
import com.no502zhang.user.model.UserUpdateVO
import org.springframework.stereotype.Service

@Service
class UserService(val userMapper: UserMapper) {
    fun createDish(user: User): User {
        userMapper.insertUser(user)
        return user
    }

    fun updateDish(id: Int, user: UserUpdateVO): Boolean {
        userMapper.updateUser(id, user)
        return true
    }

    fun deleteDish(id: Int): Boolean {
        userMapper.deleteUser(id)
        return true
    }

    fun getDish(id: Int): User {
        return userMapper.getUser(id)
    }

    fun listDish(user: UserQueryVO, page: Page<User>): PageInfo<User> {
        PageHelper.startPage<User>(page.getPageNum(), page.getPageSize())
        val list = userMapper.listUser(user)
        return PageInfo(list)
    }
}