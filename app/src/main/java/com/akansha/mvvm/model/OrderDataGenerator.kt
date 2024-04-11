package com.akansha.mvvm.model

import kotlin.random.Random

object OrderDataGenerator {
    private val currentUsers = arrayListOf<User>()
    private val currentProducts = arrayListOf<Product>()
    private val currentOrders = arrayListOf<Order>()

    init {
        for (i in 1..30){
            generateUsers()
            generateProducts()
        }
        for(i in 1..30){
            generateOrders()
        }
    }

    private fun generateUsers(){
        val index = Random.nextInt(SampleData.usersList.size)
        val userName = SampleData.usersList[index]
        val email = "$userName@gmail.com"
        val userId = 100 + currentUsers.size

        currentUsers.add(User(userId, userName, email))
    }

    private fun generateProducts(){
        val brandIndex = Random.nextInt(SampleData.brandsList.size)
        val brandName = SampleData.brandsList[brandIndex]
        val productIndex = Random.nextInt(SampleData.productsList.size)
        val productName = SampleData.productsList[productIndex]
        val price = Random.nextInt(1000)
        val productId = 200 + currentProducts.size

        currentProducts.add(Product(productId, productName, brandName, price))
    }

    private fun generateOrders(){
        val user = currentUsers[Random.nextInt(currentUsers.size)]
        val product = currentProducts[Random.nextInt(currentProducts.size)]
        val orderId = 300 + currentOrders.size

        currentOrders.add(Order(orderId, user, product))
    }
}