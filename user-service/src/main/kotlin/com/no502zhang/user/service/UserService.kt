package com.no502zhang.user.service

import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.no502zhang.user.mapper.UserMapper
import com.no502zhang.user.domain.User
import com.no502zhang.user.model.UserQueryVO
import com.no502zhang.user.model.UserUpdateVO
import org.springframework.stereotype.Service

@Service
class UserService(val userMapper: UserMapper) {
    fun createUser(user: User): User {
        userMapper.insertUser(user)
        return user
    }

    fun updateUser(id: Int, user: UserUpdateVO): Boolean {
        userMapper.updateUser(id, user)
        return true
    }

    fun deleteUser(id: Int): Boolean {
        userMapper.deleteUser(id)
        return true
    }

    fun getUser(id: Int): User {
        return userMapper.getUser(id)
    }

    fun listUser(user: UserQueryVO, pageNum: Int, pageSize: Int): PageInfo<User> {
        PageHelper.startPage<User>(pageNum, pageSize)
        val list = userMapper.listUser(user)
        return PageInfo(list)
    }
}