package com.no502zhang.scheduling.service

import com.no502zhang.scheduling.dto.*

interface JobService {
    fun createJob(param: CreateJobParam): CreateJobResult

    fun updateJob(id: String, param: UpdateJobParam): UpdateJobResult

    fun deleteJob(id: String)

    fun getJob(id: String, param: GetJobParam): GetJobResult

    fun listJobs(param: ListJobParam): ListJobReslut
}