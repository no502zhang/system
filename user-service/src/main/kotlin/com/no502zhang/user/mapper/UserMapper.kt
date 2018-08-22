package com.no502zhang.user.mapper

import com.no502zhang.user.model.User
import com.no502zhang.user.model.UserQueryVO
import com.no502zhang.user.model.UserUpdateVO
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface UserMapper {
    fun insertUser(user: User)

    fun updateUser(@Param("id") id: Int, @Param("user") user: UserUpdateVO)

    fun deleteUser(@Param("id") id: Int)

    fun getUser(@Param("id") id: Int): User?

    fun listUser(user: UserQueryVO): List<User>?
}