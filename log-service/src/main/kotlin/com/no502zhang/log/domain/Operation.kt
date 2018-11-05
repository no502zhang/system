package com.no502zhang.log.domain

import org.springframework.data.annotation.Id
import java.util.*

class Operation(id: String, code: String) {
    constructor(code: String) : this(UUID.randomUUID().toString().replace("-", ""), code)

    @Id
    val id: String = id

    var code: String = code
}