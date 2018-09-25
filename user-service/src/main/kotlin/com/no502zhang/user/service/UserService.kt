package com.no502zhang.user.service


import com.no502zhang.user.domain.User
import com.no502zhang.user.dto.*
import com.no502zhang.user.repository.UserRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {
    fun createUser(param: CreateUserParam): CreateUserResult {
        var user = User(param.name)
        userRepository.save(user)
        return CreateUserResult(user.id, user.name)
    }

    fun updateUser(id: String, param: UpdateUserParam): UpdateUserResult {
        var user = userRepository.findById(id).get()
        user.name = param.name ?: user.name
        userRepository.save(user)
        return UpdateUserResult(user.id, user.name)
    }

    fun deleteUser(id: String) {
        userRepository.deleteById(id)
    }

    fun getUser(id: String, param: GetUserParam): GetUserResult {
        var user = userRepository.findById(id).get()
        return GetUserResult(user.id, user.name)
    }

    fun listUser(param: ListUserParam): ListUserResult {
        val request = PageRequest.of(param.pageNum, param.pageSize)
        var result = userRepository.findAll(request)
        return ListUserResult(result.size, result.number, result.totalPages, result.totalElements)
    }
}