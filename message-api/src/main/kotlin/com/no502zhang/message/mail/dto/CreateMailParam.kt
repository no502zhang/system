package com.no502zhang.message.mail.dto

data class CreateMailParam(val mailTo: String, val copyTo: String? = null, val title: String, val content: String)