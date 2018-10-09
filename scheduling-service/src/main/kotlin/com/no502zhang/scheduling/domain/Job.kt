package com.no502zhang.scheduling.domain

import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "job_info")
@SQLDelete(sql = "update job_info set is_deleted = 1 where id = ?")
@Where(clause = "is_deleted = 0")
class Job(id: String, name: String, remark: String?, cron: String?) {
    constructor(name: String, remark: String? = null, cron: String? = null) : this(UUID.randomUUID().toString().replace("-", ""), name, remark, cron)

    @Id
    @Column(name = "id", updatable = false, nullable = false, length = 32)
    val id: String = id
    @Column(name = "name", nullable = false, length = 100)
    var name: String = name
    @Column(name = "remark", nullable = true)
    var remark: String? = remark
    @Column(name = "cron", nullable = true)
    var cron: String? = cron

    @Column(name = "is_deleted", nullable = false)
    private var deleted: Boolean = false
}