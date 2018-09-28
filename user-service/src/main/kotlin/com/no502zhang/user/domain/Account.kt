package com.no502zhang.user.domain

import com.no502zhang.user.vo.AccountType
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "account_info")
@SQLDelete(sql = "update user_info set is_deleted = 1 where id = ?")
@Where(clause = "is_deleted = 0")
class Account(id: String, userId: String, type: AccountType, account: String, password: String? = null) {
    constructor(userId: String, type: AccountType, account: String) : this(UUID.randomUUID().toString().replace("-", ""), userId, type, account)
    constructor(userId: String, account: String) : this(userId, AccountType.ACCOUNT, account)

    @Id
    @Column(name = "id", updatable = false, nullable = false, length = 32)
    val id: String = id
    @Column(name = "user_id", updatable = false, nullable = false, length = 32)
    val userId: String = userId
    @Column(name = "type", updatable = false, nullable = false)
    val type: AccountType = type
    @Column(name = "account", updatable = false, nullable = false)
    val account: String = account
    @Column(name = "rawPassword", nullable = true)
    var password: String? = password

    @Column(name = "is_deleted", nullable = false)
    private var deleted: Boolean = false

    fun changePassword(password: String?) {
        this.password = BCryptPasswordEncoder().encode(password)
    }
}