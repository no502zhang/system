package com.no502zhang.dict.domain

import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "dict_info")
@SQLDelete(sql = "update dict_info set is_deleted = 1 where id = ?")
@Where(clause = "is_deleted = 0")
class Dict(id: String, parentId: String?, code: String, name: String, value: String?, remark: String?) {
    constructor(parentId: String? = null, code: String, name: String, value: String? = null, remark: String? = null) : this(UUID.randomUUID().toString().replace("-", ""), parentId, code, name, value, remark)

    @Id
    @Column(name = "id", updatable = false, nullable = false, length = 32)
    val id: String = id
    @Column(name = "parent_id", updatable = false, nullable = true, length = 32)
    val parentId: String? = parentId
    @Column(name = "code", updatable = false, nullable = false, length = 100)
    val code: String = code
    @Column(name = "name", nullable = false)
    var name: String = name
    @Column(name = "val", nullable = true)
    var value: String? = value
    @Column(name = "remark", nullable = true)
    var remark: String? = remark

    @Column(name = "is_deleted", nullable = false)
    private var deleted: Boolean = false
}