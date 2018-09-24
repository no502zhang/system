package com.no502zhang.dict.repository

import com.no502zhang.dict.po.DictInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DictRepository : JpaRepository<DictInfo, String>