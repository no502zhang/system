package com.no502zhang.user.mapper

import com.no502zhang.user.model.User
import com.no502zhang.user.model.UserQueryVO
import com.no502zhang.user.model.UserUpdateVO
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface UserMapper {
    fun insertUser(user: User)

    fun updateUser(@Param("id") id: Int, @Param("user") user: UserUpdateVO): Int

    fun deleteUser(@Param("id") id: Int): Int

    fun getUser(@Param("id") id: Int): User

    fun listUser(dish: UserQueryVO): List<User>
}