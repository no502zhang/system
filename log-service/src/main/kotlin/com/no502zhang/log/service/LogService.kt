package com.no502zhang.log.service

import com.no502zhang.log.domain.Log
import org.springframework.data.domain.Page

interface LogService {
    fun createLog(remark: String?): Log

    fun getLogById(id: String): Log

    fun listLog(pageNum: Int = 1, pageSize: Int = 10): Page<Log>
}