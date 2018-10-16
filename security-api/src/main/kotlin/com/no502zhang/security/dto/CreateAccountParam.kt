package com.no502zhang.security.dto

import com.no502zhang.security.vo.AccountOwnerType

data class CreateAccountParam(val ownerType: AccountOwnerType? = AccountOwnerType.USER, val ownerId: String, val account: String, val password: String?)