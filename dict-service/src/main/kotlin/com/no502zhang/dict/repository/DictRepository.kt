package com.no502zhang.dict.repository

import com.no502zhang.dict.domain.DictInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository("dictRepository")
interface DictRepository : JpaRepository<DictInfo, String>