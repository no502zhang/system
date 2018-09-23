package com.no502zhang.dict.client

import com.no502zhang.dict.dto.*
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.*

@FeignClient("SYSTEM")
interface DictFeignClient {
    @PostMapping("/dicts/")
    fun create(@RequestBody param: CreateDictParam): CreateDictResult

    @DeleteMapping("/dicts/{id}")
    fun delete(@PathVariable("id") id: String)

    @PutMapping("/dicts/{id}")
    fun update(@PathVariable("id") id: String, @RequestBody param: UpdateDictParam): UpdateDictResult

    @GetMapping("/dicts/{id}")
    fun get(@PathVariable("id") id: String): GetDictResult

    @GetMapping("/dicts/")
    fun list(@RequestParam(name = "parentId", required = false) parentId: String?,
             @RequestParam(name = "code", required = false) code: String?,
             @RequestParam(name = "name", required = false) name: String?,
             @RequestParam(name = "pageSize", required = false, defaultValue = "1") pageSize: Int = 1,
             @RequestParam(name = "pageNum", required = false, defaultValue = "100") pageNum: Int = 100): ListDictResult
}