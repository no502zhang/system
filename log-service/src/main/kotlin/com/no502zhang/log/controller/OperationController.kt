package com.no502zhang.log.controller

import com.no502zhang.log.dto.*
import com.no502zhang.log.service.OperationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/operations")
class OperationController(private val operationService: OperationService) {

    @PostMapping("")
    fun create(@RequestBody param: CreateOperationParam): CreateOperationResult {
        val operation = operationService.createOperation(param.code)
        return CreateOperationResult(operation.id, operation.code)
    }

    @DeleteMapping("/{id}")
    fun delelte(@PathVariable("id") id: String) {

    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: String, @RequestBody param: UpdateOperationParam): UpdateOperationResult {
        return UpdateOperationResult()
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: String): GetOperationResult {
        return GetOperationResult()
    }

    @GetMapping("")
    fun list(param: ListOperationParam): ListOperationResult {
        return ListOperationResult()
    }
}