package com.no502zhang.scheduling.service.impl

import com.no502zhang.scheduling.domain.Job
import com.no502zhang.scheduling.dto.*
import com.no502zhang.scheduling.job.RestJob
import com.no502zhang.scheduling.repository.JobRepository
import com.no502zhang.scheduling.service.JobService
import org.quartz.*
import org.springframework.stereotype.Service
import org.quartz.JobKey


@Service
class JobServiceImpl(private val scheduler: Scheduler, private val jobRepository: JobRepository) : JobService {
    private val jobNamePrefix = "job"
    private val defaultJobGroup = "defaultGroup"

    private val triggerNamePrefix = "trigger"
    private val defaultTriggerGroup = "defaultGroup"

    override fun createJob(param: CreateJobParam): CreateJobResult {
        // 保存
        var job = Job(param.name, param.remark, param.cron)
        jobRepository.save(job)
        // 配置job信息
        val jobDetail = JobBuilder.newJob(RestJob::class.java).withIdentity("$jobNamePrefix#${job.id}", defaultJobGroup).build()
        // 运行参数
        jobDetail.jobDataMap["jobInfo.id"] = job.id
        jobDetail.jobDataMap["jobInfo.name"] = job.name
        // 为job配置触发器
        val scheduleBuilder = CronScheduleBuilder.cronSchedule(job.cron)
        val trigger = TriggerBuilder.newTrigger().withIdentity("$triggerNamePrefix#${job.id}", defaultTriggerGroup).withSchedule<CronTrigger>(scheduleBuilder).build()
        scheduler.scheduleJob(jobDetail, trigger)

        return CreateJobResult()
    }

    override fun updateJob(id: String, param: UpdateJobParam): UpdateJobResult {
        // TODO 查询记录
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteJob(id: String) {
        // 删除定时任务
        deleteSchedulerJob(id)
        // 删除数据库中的记录
        jobRepository.deleteById(id)
    }

    override fun getJob(id: String, param: GetJobParam): GetJobResult {
        val key = JobKey.jobKey("$jobNamePrefix#$id", defaultJobGroup)
        return scheduler.getJobDetail(key).jobDataMap["jobInfo"] as GetJobResult
    }

    override fun listJobs(param: ListJobParam): ListJobReslut {
        return ListJobReslut()
    }

    private fun deleteSchedulerJob(id: String): Boolean {
        val key = JobKey.jobKey("$jobNamePrefix#$id", defaultJobGroup)
        scheduler.deleteJob(key)
        return true
    }
}