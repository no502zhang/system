package com.no502zhang.scheduling.controller

import com.no502zhang.scheduling.dto.*
import com.no502zhang.scheduling.service.JobService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/scheduling/jobs")
class JobController(private val jobService: JobService) {

    @PostMapping("/")
    fun create(@RequestBody param: CreateJobParam): CreateJobResult {
        return jobService.createJob(param)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: String) {
        jobService.deleteJob(id)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: String,
               @RequestBody param: UpdateJobParam): UpdateJobResult {
        return jobService.updateJob(id, param)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: String, param: GetJobParam): GetJobResult {
        return jobService.getJob(id, param)
    }

    @GetMapping("/")
    fun list(param: ListJobParam): ListJobReslut {
        return jobService.listJobs(param)
    }
}