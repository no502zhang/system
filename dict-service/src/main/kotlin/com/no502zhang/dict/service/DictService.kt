package com.no502zhang.dict.service

import com.no502zhang.dict.domain.Dict
import com.no502zhang.dict.dto.*
import com.no502zhang.dict.po.DictInfo
import com.no502zhang.dict.repository.DictRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class DictService(val dictRepository: DictRepository) {

    fun createDict(param: CreateDictParam): CreateDictResult {
        // 构造一个领域对象
        var dict = Dict(param.parentId, param.code, param.name, param.data, param.remark)
        // 将领域对象放入持久化仓库
        dictRepository.save(DictInfo(dict.id, dict.parentId, dict.code, dict.name, dict.data, dict.remark))

        return CreateDictResult(dict.id, dict.parentId, dict.code, dict.name, dict.data, dict.remark)
    }

    fun deleteDict(id: String) {
        dictRepository.deleteById(id)
    }

    fun updateDict(id: String, param: UpdateDictParam): UpdateDictResult {
        // 从仓库中得到一个持久化对象
        var dictInfo = dictRepository.findById(id).get()
        // 由持久化对象中得到一个领域对象
        var dict = Dict(dictInfo.id, dictInfo.parentId, dictInfo.code, dictInfo.name, dictInfo.data, dictInfo.remark)
        // 修改对象
        dict.name = param.name ?: dict.name
        dict.data = param.data ?: dict.data
        dict.remark = param.remark ?: dict.remark
        // 保存对象
        dictRepository.save(DictInfo(dict.id, dict.parentId, dict.code, dict.name, dict.data, dict.remark))

        return UpdateDictResult(dict.id, dict.parentId, dict.code, dict.name, dict.data, dict.remark)
    }

    fun getDict(id: String): GetDictResult {
        val dict = dictRepository.findById(id).get()

        return GetDictResult(dict.id, dict.parentId, dict.code, dict.name, dict.data, dict.remark)
    }

    fun listDict(param: ListDictParam): ListDictResult {
        val request = PageRequest.of(param.pageNum, param.pageSize)
        val result = dictRepository.findAll(request)

        return ListDictResult(result.size, result.number, result.totalPages, result.totalElements)
    }
}