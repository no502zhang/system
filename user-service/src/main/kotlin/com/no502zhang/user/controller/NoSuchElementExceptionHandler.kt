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

    @ExceptionHandler(NoSuchElementException::class)
    fun handleException(): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND")
    }
}