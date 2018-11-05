package com.no502zhang.log.controller

import com.no502zhang.log.dto.*
import com.no502zhang.log.service.LogService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/logs")
class LogController(private val logService: LogService) {

    @PostMapping("")
    fun create(@RequestBody param: CreateLogParam): CreateLogResult {
        val log = logService.createLog("测试")
        return CreateLogResult(log.id)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: String, param: GetLogParam): GetLogResult {
        val log = logService.getLogById(id)
        return GetLogResult(log.id, log.logTime)
    }

    @GetMapping("")
    fun list(param: ListLogParam): ListLogResult {
        val result = logService.listLog()
        return ListLogResult()
    }
}