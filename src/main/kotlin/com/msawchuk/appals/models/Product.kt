package com.msawchuk.appals.models

import jakarta.persistence.*

@Entity
@Table(name = "products")
class Product(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
        var name: String,
        var description: String,
        var quantity: Int,
        var price: Double,
) {
    constructor() : this(0, "", "", 0, 0.0)
}
