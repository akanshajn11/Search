package com.akansha.mvvm_compose_search.model

data class User(
    val id: Int,
    val name: String,
    val email: String,
) {
    override fun toString(): String = "$name ($email)"
}

data class Product(
    val id: Int,
    val name: String,
    val brand: String,
    val price: Int,
) {
    override fun toString() = "$name - $brand ($$price)"
}

data class Order(
    val id: Int,
    val user: User,
    val product: Product,
)