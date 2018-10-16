package com.no502zhang.security.dto

import com.no502zhang.security.vo.AccountType

data class GetAccountParam(val accountType: AccountType, val account: String)