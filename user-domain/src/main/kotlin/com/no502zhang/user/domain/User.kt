package com.no502zhang.user.domain

import java.util.*

class User(val id: String, var name: String) {
    constructor(name: String) : this(UUID.randomUUID().toString().replace("-", ""), name)
}