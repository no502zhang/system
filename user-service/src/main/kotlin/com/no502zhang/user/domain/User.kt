package com.no502zhang.user.domain

import com.no502zhang.user.vo.UserType
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "user_info")
@SQLDelete(sql = "update user_info set is_deleted = 1 where id = ?")
@Where(clause = "is_deleted = 0")
class User(id: String, type: UserType, name: String, remark: String? = null) {
    constructor(type: UserType, name: String, remark: String? = null) : this(UUID.randomUUID().toString().replace("-", ""), type, name, remark)
    constructor(name: String, remark: String? = null) : this(UUID.randomUUID().toString().replace("-", ""), UserType.PERSONAL, name, remark)

    @Id
    @Column(name = "id", updatable = false, nullable = false, length = 32)
    val id: String = id
    @Column(name = "typ", updatable = false, nullable = false)
    val type: UserType = type
    @Column(name = "name", nullable = false, length = 100)
    var name: String = name
    @Column(name = "remark", nullable = true)
    var remark: String? = remark
    @Column(name = "is_deleted", nullable = false)
    private var deleted: Boolean = false
}