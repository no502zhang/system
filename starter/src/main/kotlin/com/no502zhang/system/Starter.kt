package com.no502zhang.system

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.runApplication
import org.springframework.cloud.client.SpringCloudApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan


@SpringCloudApplication
@ComponentScan("com.no502zhang")
@MapperScan("com.no502zhang")
@EnableFeignClients
class Starter

fun main(args: Array<String>) {
    runApplication<Starter>(*args)
}