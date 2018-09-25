package com.no502zhang.user.domain

import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user_info")
@SQLDelete(sql = "update user_info set is_deleted = 1 where id = ?")
@Where(clause = "is_deleted = 0")
class User(
        @Id
        @Column(name = "id", updatable = false, length = 32)
        val id: String,
        @Column(name = "name", nullable = false, length = 200)
        var name: String,
        @Column(name = "remark", nullable = true)
        var remark: String? = null) {
    constructor(name: String, remark: String? = null) : this(UUID.randomUUID().toString().replace("-", ""), name, remark)

    @Column(name = "is_deleted", nullable = false, length = 1)
    var deleted: Byte = 0
}