package com.no502zhang.scheduling.configration

import org.springframework.web.client.RestTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InitConfigration {
    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}