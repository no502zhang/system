package com.no502zhang.user.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * TODO 抽取到core中
 */
@RestControllerAdvice
class NoSuchElementExceptionHandler {

    // 返回200状态, body中写异常信息
    @ExceptionHandler(NoSuchElementException::class)
    fun handleException(): ResponseEntity<String> {
        return ResponseEntity.ok().body("{\n" +
                "    \"timestamp\": \"2018-09-25T23:25:17.373+0000\",\n" +
                "    \"status\": 404,\n" +
                "    \"error\": \"Not Found\",\n" +
                "    \"message\": \"No message available\",\n" +
                "    \"path\": \"/system/userss/41\"\n" +
                "}")
    }
}