package com.no502zhang.user.service.impl

import com.no502zhang.security.client.AccountFeignClient
import com.no502zhang.security.dto.CreateAccountParam
import com.no502zhang.user.domain.User
import com.no502zhang.user.dto.*
import com.no502zhang.user.repository.UserRepository
import com.no502zhang.user.service.UserService
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(val userRepository: UserRepository, val accountFeignClient: AccountFeignClient) : UserService {
    override fun createUser(param: CreateUserParam): CreateUserResult {
        var user = User(param.name, param.remark)

        userRepository.save(user)

        accountFeignClient.create(CreateAccountParam(ownerId = user.id, account = param.account, password = param.password))

        return CreateUserResult(user.id, user.name, user.remark)
    }

    override fun updateUser(id: String, param: UpdateUserParam): UpdateUserResult {
        var user = userRepository.findById(id).get()
        user.name = param.name ?: user.name
        user.remark = param.remark ?: user.remark
        userRepository.save(user)
        return UpdateUserResult(user.id, user.name, user.remark)
    }

    override fun deleteUser(id: String) {
        userRepository.deleteById(id)
    }

    override fun getUser(id: String, param: GetUserParam): GetUserResult {
        var user = userRepository.findById(id).get()
        return GetUserResult(user.id, user.name, user.remark)
    }

    override fun listUser(param: ListUserParam): ListUserResult {
        val request = PageRequest.of(param.pageNum, param.pageSize)
        var result = userRepository.findAll(request)
        return ListUserResult(result.size, result.number, result.totalPages, result.totalElements)
    }
}