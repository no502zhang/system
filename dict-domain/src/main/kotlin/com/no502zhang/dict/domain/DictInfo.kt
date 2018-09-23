package com.no502zhang.dict.domain

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "dict_info")
class DictInfo(
        @Id
        @Column(name = "id", updatable = false, length = 32)
        val id: String,
        @Column(name = "parent_id", nullable = true, length = 32)
        val parentId: String? = null,
        @Column(name = "code", nullable = false, length = 100)
        val code: String,
        @Column(name = "name", nullable = false)
        var name: String,
        @Column(name = "data", nullable = true)
        var data: String? = null,
        @Column(name = "remark", nullable = true)
        var remark: String? = null) {
    constructor(parentId: String? = null, code: String, name: String, data: String? = null, remark: String? = null
    ) : this(UUID.randomUUID().toString().replace("-", ""), parentId, code, name, data, remark)
}