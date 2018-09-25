package com.no502zhang.dict.repository

import com.no502zhang.dict.domain.Dict
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DictRepository : JpaRepository<Dict, String>