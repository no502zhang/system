package com.no502zhang.user.service


import com.no502zhang.user.domain.User
import com.no502zhang.user.dto.*
import com.no502zhang.user.po.UserInfo
import com.no502zhang.user.repository.UserRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {
    fun createUser(param: CreateUserParam): CreateUserResult {
        var user = User(param.name)
        userRepository.save(UserInfo(user.id, user.name))
        return CreateUserResult(user.id, user.name)
    }

    fun updateUser(id: String, param: UpdateUserParam): UpdateUserResult {
        var userInfo = userRepository.findById(id).get()
        var user = User(userInfo.id, userInfo.name)
        user.name = param.name ?: user.name
        userRepository.save(UserInfo(user.id, user.name))
        return UpdateUserResult(user.id, user.name)
    }

    fun deleteUser(id: String) {
        userRepository.deleteById(id)
    }

    fun getUser(id: String, param: GetUserParam): GetUserResult {
        var userInfo = userRepository.findById(id).get()
        return GetUserResult(userInfo.id, userInfo.name)
    }

    fun listUser(param: ListUserParam): ListUserResult {
        val request = PageRequest.of(param.pageNum, param.pageSize)
        var result = userRepository.findAll(request)
        return ListUserResult(result.size, result.number, result.totalPages, result.totalElements)
    }
}