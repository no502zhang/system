package com.no502zhang.user.repository

import com.no502zhang.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String>