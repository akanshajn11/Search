package com.akansha.mvvm.view.design

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.akansha.mvvm.model.Order

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(orders: List<Order>, onSearchTextChanged: (String) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Orders") })
        }
    ) { paddingValues ->
        ConstraintLayout(
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {
            val (text, recyclerView) = createRefs()
            val textState = remember {
                mutableStateOf(TextFieldValue())
            }
            TextField(value = textState.value, onValueChange = {
                textState.value = it
                onSearchTextChanged(it.text)
            },
                Modifier
                    .constrainAs(text) {
                        top.linkTo(parent.top, margin = 64.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(recyclerView.top)
                    }
                    .fillMaxWidth(),
                placeholder = { Text("Search order") }
            )
            LazyColumn(
                Modifier
                    .constrainAs(recyclerView) {
                        top.linkTo(text.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            ) {
                items(orders) {
                    OrderItem(it)
                }
            }
        }
    }
}
