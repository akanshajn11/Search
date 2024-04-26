package com.akansha.mvvm_compose_search.view.design

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.akansha.mvvm_compose_search.R
import com.akansha.mvvm_compose_search.model.LoadingState
import com.akansha.mvvm_compose_search.model.Order

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchOrderScreen(
    loadingState: LoadingState,
    searchQuery: String,
    orders: List<Order>?,
    onSearchQueryChange: (String) -> Unit,
) {
    SearchBar(
        query = searchQuery,
        onQueryChange = onSearchQueryChange,
        onSearch = {},
        placeholder = { Text(text = stringResource(id = R.string.search_bar_placeholder)) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                tint = MaterialTheme.colorScheme.onSurface,
                contentDescription = null,
            )
        },
        trailingIcon = {
            if (searchQuery.isNotEmpty()) {
                IconButton(onClick = { onSearchQueryChange("") }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        tint = MaterialTheme.colorScheme.onSurface,
                        contentDescription = stringResource(id = R.string.clear_search)
                    )
                }
            }
        },
        active = true,
        onActiveChange = {},
        content = {
            when (loadingState) {
                LoadingState.LOADING -> LoadingView()
                LoadingState.ERROR -> ErrorView()
                LoadingState.LOADED -> {
                    if (orders.isNullOrEmpty()) {
                        EmptyView()
                    } else {
                        OrderListView(orders)
                    }
                }
            }
        }
    )
}