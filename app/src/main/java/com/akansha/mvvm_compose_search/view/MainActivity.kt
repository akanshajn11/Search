package com.akansha.mvvm_compose_search.view

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.akansha.mvvm_compose_search.model.LoadingState
import com.akansha.mvvm_compose_search.view.design.SearchOrderScreen
import com.akansha.mvvm_compose_search.view.theme.AppTheme
import com.akansha.mvvm_compose_search.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onResume() {
        super.onResume()
        initializeObservers()
        viewModel.onViewReady()
    }

    private fun initializeObservers() {
        viewModel.loadingStateLiveData.observe(this, Observer {
            if (it != LoadingState.LOADED) {
                updateUI(it)
            }
        })
        viewModel.ordersLiveData.observe(this, Observer {
            updateUI(LoadingState.LOADED)
        })
    }

    private fun updateUI(state: LoadingState) {
        setContent {
            AppTheme {
                SearchOrderScreen(
                    loadingState = state,
                    searchQuery = viewModel.searchQuery,
                    orders = viewModel.getCurrentOrders(),
                    onSearchQueryChange = { viewModel.onSearchQuery(it) }
                )
            }
        }
    }
}