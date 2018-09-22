package com.no502zhang.dict.service

import com.no502zhang.dict.domain.DictInfo
import com.no502zhang.dict.repository.DictRepository

class DictService(val dictRepository: DictRepository) {

    fun createDict() {
        //TODO 初始化一个领域对象

        //TODO 将领域对象放入持久化仓库
        dictRepository.save(DictInfo("id", null, "code", "name", "data", "remark"))
    }

    fun getDict() {
        dictRepository.findById("id")
    }
}