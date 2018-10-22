package com.no502zhang.starter

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.cloud.client.SpringCloudApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringCloudApplication
@ComponentScan("com.no502zhang")
// JPA依赖包来自于服务
@EnableJpaRepositories("com.no502zhang")
// MongoDB依赖包来自于服务
@EnableMongoRepositories("com.no502zhang")
@EntityScan("com.no502zhang")
@EnableFeignClients("com.no502zhang")
class StarterApplication

fun main(args: Array<String>) {
    runApplication<StarterApplication>(*args)
}
