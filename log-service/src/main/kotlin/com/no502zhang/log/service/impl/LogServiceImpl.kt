package com.no502zhang.log.service.impl

import com.no502zhang.log.domain.Log
import com.no502zhang.log.repository.LogRepository
import com.no502zhang.log.service.LogService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class LogServiceImpl(private val logRepository: LogRepository) : LogService {

    override fun createLog(remark: String?): Log {
        var log = Log(remark)
        logRepository.save(log)
        return log
    }

    override fun getLogById(id: String): Log {
        return logRepository.findById(id).get()
    }

    override fun listLog(pageNum: Int, pageSize: Int): Page<Log> {
        val request = PageRequest.of(pageNum, pageSize)
        return logRepository.findAll(request)
    }
}