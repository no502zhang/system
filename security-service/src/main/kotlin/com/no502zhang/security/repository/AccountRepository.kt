package com.no502zhang.security.repository

import com.no502zhang.security.domain.Account
import com.no502zhang.security.vo.AccountOwnerType
import com.no502zhang.security.vo.AccountType
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, String> {
    fun findByOwnerTypeAndOwnerId(ownerType: AccountOwnerType = AccountOwnerType.USER, ownerId: String): Set<Account>

    fun findByTypeAndAccount(type: AccountType = AccountType.ACCOUNT, account: String): Account
}