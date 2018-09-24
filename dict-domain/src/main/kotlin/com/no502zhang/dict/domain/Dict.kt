package com.no502zhang.dict.domain

import java.util.*

class Dict(val id: String, val parentId: String? = null, val code: String, var name: String, var data: String? = null, var remark: String? = null) {
    constructor(parentId: String? = null, code: String, name: String, data: String? = null, remark: String? = null) : this(UUID.randomUUID().toString().replace("-", ""), parentId, code, name, data, remark)
}