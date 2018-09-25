package com.no502zhang.starter

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.cloud.client.SpringCloudApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringCloudApplication
@ComponentScan("com.no502zhang")
@EnableJpaRepositories("com.no502zhang")
@EntityScan("com.no502zhang")
@EnableFeignClients
class StarterApplication

fun main(args: Array<String>) {
    runApplication<StarterApplication>(*args)
}
