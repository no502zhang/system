package com.no502zhang.log.service.impl

import com.no502zhang.log.domain.Operation
import com.no502zhang.log.repository.OperationRepository
import com.no502zhang.log.service.OperationService
import org.springframework.stereotype.Service

@Service
class OperationServiceImpl(private val operationRepository: OperationRepository) : OperationService {

    override fun createOperation(code: String): Operation {
        var operation = Operation(code = code)
        operationRepository.save(operation)
        return operation
    }
}