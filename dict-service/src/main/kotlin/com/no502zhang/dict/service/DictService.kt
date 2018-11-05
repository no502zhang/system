package com.no502zhang.dict.service

import com.no502zhang.dict.dto.*

interface DictService {
    fun createDict(param: CreateDictParam): CreateDictResult

    fun deleteDict(id: String)

    fun updateDict(id: String, param: UpdateDictParam): UpdateDictResult

    fun getDict(id: String): GetDictResult

    fun listDict(param: ListDictParam): ListDictResult
}