package com.msawchuk.appals.repositories

import com.msawchuk.appals.models.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
