package com.no502zhang.user.repository

import com.no502zhang.user.po.UserInfo
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserInfo, String>