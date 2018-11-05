package com.no502zhang.user.service

import com.no502zhang.user.dto.*

interface UserService {
    fun createUser(param: CreateUserParam): CreateUserResult

    fun updateUser(id: String, param: UpdateUserParam): UpdateUserResult

    fun deleteUser(id: String)

    fun getUser(id: String, param: GetUserParam): GetUserResult

    fun listUser(param: ListUserParam): ListUserResult
}