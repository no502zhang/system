package com.no502zhang.security.vo

import java.util.*

data class Token(
        /**
         * token唯一标识
         */
        val jti: String = UUID.randomUUID().toString().replace("-", ""),
        /**
         * 签发者(授权APPID, 通常为security服务APPID)
         */
        val iss: String? = null,
        /**
         * 提供者(资源ID, 如userId)
         */
        val sub: String? = null,
        /**
         * 接收者(请求APPID, 前端APPID)
         */
        val aud: String? = null,
        /**
         * 签发时间
         */
        val iat: Date = Date(),
        /**
         * 生效时间
         */
        val nbf: Date = Date(),
        /**
         * 过期时间
         */
        val exp: Date? = null
)