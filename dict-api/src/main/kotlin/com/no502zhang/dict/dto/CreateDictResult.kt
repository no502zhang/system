package com.no502zhang.dict.dto

data class CreateDictResult(val id: String, val parentId: String?, val code: String, var name: String, var value: String?, var remark: String?)