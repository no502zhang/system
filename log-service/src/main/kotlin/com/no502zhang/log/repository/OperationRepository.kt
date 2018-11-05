package com.no502zhang.log.repository

import com.no502zhang.log.domain.Operation
import org.springframework.data.mongodb.repository.MongoRepository

interface OperationRepository : MongoRepository<Operation, String>