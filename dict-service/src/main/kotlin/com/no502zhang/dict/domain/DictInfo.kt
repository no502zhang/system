package com.no502zhang.dict.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "dict_info")
class DictInfo(
        @Id
        @Column(name = "id", updatable = false)
        val id: String,
        @Column(name = "parent_id", nullable = true)
        val parentId: String? = null,
        @Column(name = "code", nullable = false)
        val code: String,
        @Column(name = "name", nullable = false)
        var name: String,
        @Column(name = "data", nullable = true)
        var data: String? = null,
        @Column(name = "remark", nullable = true)
        var remark: String? = null)