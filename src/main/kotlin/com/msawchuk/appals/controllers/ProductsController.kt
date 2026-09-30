package com.msawchuk.appals.controllers

import com.msawchuk.appals.models.Product
import com.msawchuk.appals.repositories.ProductRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductsController(private val productRepository: ProductRepository) {
    @GetMapping
    fun getAllProducts(): List<Product> {
        return productRepository.findAll()
    }

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Long): Product? {
        return productRepository.findByIdOrNull(id)
    }

    @PostMapping
    fun createProduct(@RequestBody product: Product): Product {
        return productRepository.save(product)
    }

    @PutMapping("/{id}")
    fun updateProduct(
            @PathVariable id: Long,
            @RequestBody product: Product
    ): ResponseEntity<Product> {
        var entity = productRepository.findByIdOrNull(id)
        if (entity != null) {
            entity.name = product.name
            entity.description = product.description
            entity.quantity = product.quantity
            entity.price = product.price

            var savedEntity = productRepository.save(entity)
            return ResponseEntity.ok(savedEntity)
        } else {
            return ResponseEntity.notFound().build<Product>()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Long): ResponseEntity<Void> {
        var entity = productRepository.findByIdOrNull(id)
        if (entity != null) {
            productRepository.deleteById(id)

            return ResponseEntity(HttpStatus.NO_CONTENT)
        } else {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}
