package com.no502zhang.dict.po

import com.no502zhang.dict.domain.Dict
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "dict_info")
@SQLDelete(sql = "update dict_info set is_deleted = 1 where id = ?")
@Where(clause = "is_deleted = 0")
data class DictInfo(
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
        var remark: String? = null,
        @Column(name = "is_deleted", nullable = false, length = 1)
        var deleted: Byte = 0)