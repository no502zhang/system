package com.no502zhang.security.domain

import com.no502zhang.security.vo.AccountOwnerType
import com.no502zhang.security.vo.AccountType
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
@SQLDelete(sql = "update account_info set is_deleted = 1 where id = ?")
@Where(clause = "is_deleted = 0")
class Account(id: String, ownerType: AccountOwnerType, ownerId: String, type: AccountType, account: String, password: String? = null) {
    constructor(ownerType: AccountOwnerType = AccountOwnerType.USER, ownerId: String, type: AccountType = AccountType.ACCOUNT, account: String) : this(UUID.randomUUID().toString().replace("-", ""), ownerType, ownerId, type, account)

    @Id
    @Column(name = "id", updatable = false, nullable = false, length = 32)
    val id: String = id
    @Column(name = "owner_type", updatable = false, nullable = false)
    val ownerType: AccountOwnerType = ownerType
    @Column(name = "owner_id", updatable = false, nullable = false, length = 32)
    val ownerId: String = ownerId
    @Column(name = "typ", updatable = false, nullable = false)
    val type: AccountType = type
    @Column(name = "account", updatable = false, nullable = false)
    val account: String = account
    @Column(name = "password", nullable = true)
    var password: String? = password

    @Column(name = "is_deleted", nullable = false)
    private var deleted: Boolean = false

    fun changePassword(password: String) {
        this.password = BCryptPasswordEncoder().encode(password)
    }

    fun checkPassword(password: String): Boolean {
        return BCryptPasswordEncoder().matches(password, this.password)
    }
}