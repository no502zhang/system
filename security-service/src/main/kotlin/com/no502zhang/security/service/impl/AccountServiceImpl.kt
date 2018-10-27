package com.no502zhang.security.service.impl

import com.no502zhang.security.domain.Account
import com.no502zhang.security.dto.*
import com.no502zhang.security.repository.AccountRepository
import com.no502zhang.security.service.AccountService
import com.no502zhang.security.vo.AccountType
import com.no502zhang.user.client.UserFeignClient
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(val accountRepository: AccountRepository, val userFeignClient: UserFeignClient) : AccountService {

    override fun createUserAccount(userId: String, account: String, password: String): Account {
        // 查找用户是否存在
        userFeignClient.get(userId)

        var account = Account(ownerId = userId, account = account)
        account.changePassword(password)
        accountRepository.save(account)

        return account
    }

    override fun deleteAccount(id: String) {
        accountRepository.deleteById(id)
    }

    override fun updateAccount(id: String, param: UpdateAccountParam): UpdateAccountResult {
        var account = accountRepository.findById(id).get()
        account.changePassword(param.password)
        accountRepository.save(account)
        return UpdateAccountResult()
    }

    override fun getAccountByTypeAndAccount(accountType: AccountType, account: String): Account {
        return accountRepository.findByTypeAndAccount(accountType, account)
    }

    override fun listAccount(param: ListAccountParam): ListAccountResult {
        accountRepository.findByOwnerTypeAndOwnerId(param.ownerType, param.ownerId)
        return ListAccountResult(param.ownerType, param.ownerId)
    }
}