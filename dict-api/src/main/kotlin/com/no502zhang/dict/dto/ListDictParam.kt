package com.no502zhang.dict.dto

data class ListDictParam(val parentId: String?, val code: String?, val name: String?, val pageNum: Int = 1, val pageSize: Int = 100)