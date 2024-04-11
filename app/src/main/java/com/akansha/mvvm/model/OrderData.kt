package com.akansha.mvvm.model

data class User(
    val id: Int,
    val name: String,
    val email: String,
)

data class Product(
    val id: Int,
    val name: String,
    val brand: String,
    val price: Int
){
    override fun toString() = "$name - $brand ($$price)"
}

data class Order(
    val id: Int,
    val user: User,
    val product: Product,
)