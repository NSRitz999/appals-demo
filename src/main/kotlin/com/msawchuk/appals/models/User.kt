package com.msawchuk.appals.models

import jakarta.persistence.*

@Entity
@Table(name = "users")
class User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = 0,
        var firstName: String,
        var lastName: String,
        var balance: Double,
) {
    constructor() : this(0, "", "", 0.0)
}
