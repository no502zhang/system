package com.no502zhang.user.service.impl

import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.no502zhang.user.mapper.UserMapper
import com.no502zhang.user.model.User
import com.no502zhang.user.model.UserQueryVO
import com.no502zhang.user.model.UserUpdateVO
import com.no502zhang.user.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(val userMapper: UserMapper) : UserService {
    override fun createUser(user: User): User {
        userMapper.insertUser(user)
        return user
    }

    override fun updateUser(id: Int, user: UserUpdateVO): Boolean {
        userMapper.updateUser(id, user)
        return true
    }

    override fun deleteUser(id: Int): Boolean {
        userMapper.deleteUser(id)
        return true
    }

    override fun getUser(id: Int): User? {
        return userMapper.getUser(id)
    }

    override fun listUser(user: UserQueryVO, pageNum: Int, pageSize: Int): PageInfo<User?> {
        PageHelper.startPage<User>(pageNum, pageSize)
        val list = userMapper.listUser(user)
        return PageInfo(list)
    }
}