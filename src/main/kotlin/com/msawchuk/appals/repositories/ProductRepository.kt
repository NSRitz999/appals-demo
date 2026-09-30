package com.msawchuk.appals.repositories

import com.msawchuk.appals.models.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>
