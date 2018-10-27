package com.no502zhang.security.dto

import com.no502zhang.security.vo.AccountType

data class CreateTokenParam(val accountType: AccountType = AccountType.ACCOUNT, val account: String, val password: String?)