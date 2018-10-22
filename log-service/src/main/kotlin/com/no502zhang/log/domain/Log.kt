package com.no502zhang.log.domain

import org.springframework.data.annotation.Id
import java.util.*

class Log(id: String, logTime: Date = Date(), remark: String?) {
    constructor(remark: String?) : this(UUID.randomUUID().toString().replace("-", ""), Date(), remark)

    @Id
    val id: String = id

    val logTime: Date = logTime

    var remark: String? = remark
}