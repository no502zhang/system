package com.no502zhang.security.service

import com.no502zhang.security.domain.Account
import com.no502zhang.security.dto.*
import com.no502zhang.security.vo.AccountType

interface AccountService {
    fun createUserAccount(userId: String, account: String, password: String): Account

    fun deleteAccount(id: String)

    fun updateAccount(id: String, param: UpdateAccountParam): UpdateAccountResult

    fun getAccountByTypeAndAccount(accountType: AccountType, account: String): Account

    fun listAccount(param: ListAccountParam): ListAccountResult
}