package com.no502zhang.log.repository

import com.no502zhang.log.domain.Log
import org.springframework.data.mongodb.repository.MongoRepository

interface LogRepository : MongoRepository<Log, String>