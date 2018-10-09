package com.no502zhang.scheduling.repository

import com.no502zhang.scheduling.domain.Job
import org.springframework.data.jpa.repository.JpaRepository

interface JobRepository : JpaRepository<Job, String>