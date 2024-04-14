package com.akansha.mvvm.view.design

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.akansha.mvvm.model.Order

@Composable
fun OrderItem(order: Order) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "${order.id}",
            modifier = Modifier.padding(start = 5.dp)
        )
        Text(
            text = "${order.product}",
            modifier = Modifier.padding(start = 5.dp)
        )
        Text(
            text = "${order.user}",
            modifier = Modifier.padding(start = 5.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}