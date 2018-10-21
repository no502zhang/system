package com.no502zhang.security.dto

import java.util.*

data class CreateTokenResult(val type: String = "jwt", val token: String, val expires: Date)