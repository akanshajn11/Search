package com.akansha.mvvm_compose_search.view.design

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.akansha.mvvm_compose_search.model.Order
import com.akansha.mvvm_compose_search.model.Product
import com.akansha.mvvm_compose_search.model.User
import com.akansha.mvvm_compose_search.view.theme.AppTheme

@Composable
fun OrderItemView(order: Order) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(AppTheme.spacings.spacings16)
    ) {
        Column(
            modifier = Modifier.padding(AppTheme.spacings.spacings16)
        ) {
            Text(text = "${order.id}")
            Spacer(modifier = Modifier.height(AppTheme.spacings.spacings8))
            Text(text = "${order.product}")
            Spacer(modifier = Modifier.height(AppTheme.spacings.spacings8))
            Text(text = "${order.user}")
        }
    }
}

@Preview
@Composable
fun OrderItemPreview() {
    OrderItemView(
        order = Order(
            id = 300,
            user = User(12, "Akansha", "akansha@gmail.com"),
            product = Product(10, "Laptop", "Apple", 900)
        )
    )
}