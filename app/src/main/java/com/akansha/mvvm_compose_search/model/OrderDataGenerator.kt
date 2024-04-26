package com.akansha.mvvm_compose_search.model

import kotlinx.coroutines.delay
import kotlin.random.Random

object OrderDataGenerator {
    private val currentUsers = arrayListOf<User>()
    private val currentProducts = arrayListOf<Product>()
    private val currentOrders = arrayListOf<Order>()

    private const val STD_DELAY = 2000L

    init {
        for (i in 1..30) {
            generateUsers()
            generateProducts()
        }
        for (i in 1..30) {
            generateOrders()
        }
    }

    private fun generateUsers() {
        val index = Random.nextInt(SampleData.usersList.size)
        val userName = SampleData.usersList[index]
        val email = "$userName@gmail.com"
        val userId = 100 + currentUsers.size

        currentUsers.add(User(userId, userName, email))
    }

    private fun generateProducts() {
        val brandIndex = Random.nextInt(SampleData.brandsList.size)
        val brandName = SampleData.brandsList[brandIndex]
        val productIndex = Random.nextInt(SampleData.productsList.size)
        val productName = SampleData.productsList[productIndex]
        val price = Random.nextInt(1000)
        val productId = 200 + currentProducts.size

        currentProducts.add(Product(productId, productName, brandName, price))
    }

    private fun generateOrders() {
        val user = currentUsers[Random.nextInt(currentUsers.size)]
        val product = currentProducts[Random.nextInt(currentProducts.size)]
        val orderId = 300 + currentOrders.size

        currentOrders.add(Order(orderId, user, product))
    }

    suspend fun getAllOrders(): List<Order> {
        delay(STD_DELAY)
        return currentOrders
    }

    suspend fun searchOrders(query: String): List<Order> {
        delay(STD_DELAY)
        return currentOrders.filter { order ->
            order.product.name.lowercase().contains(query.lowercase()) or
                    order.product.brand.lowercase().contains(query.lowercase()) or
                    order.user.name.lowercase().contains(query.lowercase()) or
                    order.user.email.lowercase().contains(query.lowercase())
        }
    }
}