package com.no502zhang.user.repository

import com.no502zhang.user.domain.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, String> {
    fun findByUserId(userId: String): Set<Account>
}