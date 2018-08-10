package com.no502zhang.system

import org.springframework.boot.runApplication
import org.springframework.cloud.client.SpringCloudApplication
import org.springframework.context.annotation.ComponentScan


@SpringCloudApplication
@ComponentScan(basePackages = ["com.no502zhang"])
class Starter

fun main(args: Array<String>) {
    runApplication<Starter>(*args)
}