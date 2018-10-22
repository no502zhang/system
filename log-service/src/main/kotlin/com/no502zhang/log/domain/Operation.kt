package com.no502zhang.log.domain

import org.springframework.data.annotation.Id

class Operation(id: String) {
    @Id
    val id: String = id
}