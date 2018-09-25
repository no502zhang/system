package com.no502zhang.user.domain

import com.no502zhang.user.vo.AccountType
import java.util.*

class Account(val id: String, val type: AccountType, val account: String, var password: String?) {
    constructor(type: AccountType, account: String, password: String?) : this(UUID.randomUUID().toString().replace("-", ""), type, account, password)
    constructor(account: String, password: String) : this(AccountType.ACCOUNT, account, password)
}