package com.no502zhang.dict.controller

import com.github.pagehelper.PageInfo
import com.no502zhang.dict.domain.DictInfo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/dicts")
class DictController() {

    @PostMapping("/")
    fun create(@RequestBody dictInfo: DictInfo): ResponseEntity<DictInfo> {
        return ResponseEntity.ok().body(dictInfo)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int): ResponseEntity<Boolean> {
        return ResponseEntity.ok().body(true)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Int,
               @RequestBody dictInfo: DictInfo): ResponseEntity<Boolean> {
        val flag = false
        return ResponseEntity.ok().body(flag)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Int): ResponseEntity<DictInfo> {
        val job = DictInfo(id)
        return ResponseEntity.ok().body(job)
    }

    @GetMapping("/")
    fun list(dictInfo: DictInfo, @RequestParam(value = "pageNum", required = false) pageNum: Int = 1, @RequestParam(value = "pageSize", required = false) pageSize: Int = 10): ResponseEntity<PageInfo<DictInfo>> {
        return ResponseEntity.notFound().build()
    }
}