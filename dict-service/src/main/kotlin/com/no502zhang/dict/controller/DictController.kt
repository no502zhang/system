package com.no502zhang.dict.controller

import com.no502zhang.dict.dto.*
import com.no502zhang.dict.service.DictService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/dicts")
class DictController(val dictService: DictService) {

    @PostMapping("")
    fun create(@RequestBody param: CreateDictParam): CreateDictResult {
        return dictService.createDict(param)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: String) {
        dictService.deleteDict(id)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: String, @RequestBody param: UpdateDictParam): UpdateDictResult {
        return dictService.updateDict(id, param)
    }

    @GetMapping(value = ["/{id}", "/"])
    fun get(@PathVariable("id") id: String, param: GetDictParam?): GetDictResult {
        return dictService.getDict(id)
    }

    @GetMapping("")
    fun list(param: ListDictParam): ListDictResult {
        return dictService.listDict(param)
    }
}