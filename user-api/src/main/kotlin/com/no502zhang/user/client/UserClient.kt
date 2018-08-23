package com.no502zhang.user.client

import org.springframework.cloud.openfeign.FeignClient

@FeignClient("SYSTEM")
interface UserClient {
}