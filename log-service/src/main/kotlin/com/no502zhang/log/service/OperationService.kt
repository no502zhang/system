package com.no502zhang.log.service

import com.no502zhang.log.domain.Operation

interface OperationService {
    fun createOperation(code:String):Operation
}