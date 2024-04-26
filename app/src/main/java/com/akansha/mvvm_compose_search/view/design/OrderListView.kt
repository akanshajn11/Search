package com.akansha.mvvm_compose_search.view.design

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.akansha.mvvm_compose_search.model.Order
import com.akansha.mvvm_compose_search.model.Product
import com.akansha.mvvm_compose_search.model.User

@Composable
fun OrderListView(orders: List<Order>) {
    LazyColumn(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ) {
        items(orders) {
            OrderItemView(it)
        }
    }
}

@Preview
@Composable
fun OrderListPreview() {
    OrderListView(
        orders = listOf(
            Order(
                id = 300,
                user = User(12, "Akansha", "akansha@gmail.com"),
                product = Product(10, "Laptop", "Apple", 900)
            ),
            Order(
                id = 301,
                user = User(12, "Akansha", "akansha@gmail.com"),
                product = Product(11, "Phone", "Pixel", 200)
            ),
        )
    )
}