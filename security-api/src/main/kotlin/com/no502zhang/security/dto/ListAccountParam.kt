package com.no502zhang.security.dto

import com.no502zhang.security.vo.AccountOwnerType

data class ListAccountParam(val ownerType: AccountOwnerType, val ownerId: String)