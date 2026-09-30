package com.msawchuk.appals.controllers

import com.msawchuk.appals.models.User
import com.msawchuk.appals.repositories.UserRepository
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
@RequestMapping("/users")
class UsersController(
        private val userRepository: UserRepository,
) {
    @GetMapping
    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): User? {
        return userRepository.findByIdOrNull(id)
    }

    @PostMapping
    fun createUser(@RequestBody user: User): User {
        return userRepository.save(user)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody user: User): ResponseEntity<User> {
        var entity = userRepository.findByIdOrNull(id)
        if (entity != null) {
            entity.firstName = user.firstName
            entity.lastName = user.lastName
            entity.balance = user.balance

            var savedEntity = userRepository.save(entity)
            return ResponseEntity.ok(savedEntity)
        } else {
            return ResponseEntity.notFound().build<User>()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
        var entity = userRepository.findByIdOrNull(id)
        if (entity != null) {
            userRepository.deleteById(id)

            return ResponseEntity(HttpStatus.NO_CONTENT)
        } else {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}
