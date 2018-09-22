package com.no502zhang.dict.controller

import com.github.pagehelper.PageInfo
import com.no502zhang.dict.domain.DictInfo
import com.no502zhang.dict.dto.GetDictResult
import com.no502zhang.dict.service.DictService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/dicts")
class DictController(val dictService: DictService) {

    @PostMapping("/")
    fun create(@RequestBody dictInfo: DictInfo): ResponseEntity<DictInfo> {
        return ResponseEntity.ok().body(dictInfo)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: String): ResponseEntity<Boolean> {
        return ResponseEntity.ok().body(true)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Int,
               @RequestBody dictInfo: DictInfo): ResponseEntity<Boolean> {
        val flag = false
        return ResponseEntity.ok().body(flag)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: String): ResponseEntity<GetDictResult> {
        val dictResult = GetDictResult(id, "parentId", "code", "name", "data", "remark")
        return ResponseEntity.ok().body(dictResult)
    }

    @GetMapping("/")
    fun list(dictInfo: DictInfo, @RequestParam(value = "pageNum", required = false) pageNum: Int = 1, @RequestParam(value = "pageSize", required = false) pageSize: Int = 10): ResponseEntity<PageInfo<DictInfo>> {
        return ResponseEntity.notFound().build()
    }
}