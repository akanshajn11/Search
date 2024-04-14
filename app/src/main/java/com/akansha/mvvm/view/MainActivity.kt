package com.akansha.mvvm.view

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.akansha.mvvm.model.LoadingState
import com.akansha.mvvm.model.Order
import com.akansha.mvvm.view.design.ErrorScreen
import com.akansha.mvvm.view.design.MainScreen
import com.akansha.mvvm.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onResume() {
        super.onResume()
        initializeObservers()
        viewModel.onViewReady()
    }

    private fun initializeUI(loadingState: LoadingState, orders: List<Order>) {
        setContent {
            MainScreen(loadingState, orders, onSearchTextChanged = { viewModel.onSearchQuery(it) })
        }
    }

    private fun initializeObservers() {
        viewModel.loadingStateLiveData.observe(this, Observer {
            onLoadingStateChanged(it)
        })
        viewModel.ordersLiveData.observe(this, Observer {
            initializeUI(LoadingState.LOADED, it)
        })
    }

    private fun onLoadingStateChanged(state: LoadingState) {
        setContent {
            when (state) {
                LoadingState.LOADED -> viewModel.getCurrentOrders()
                    ?.let { initializeUI(LoadingState.LOADED, it) }

                LoadingState.LOADING -> viewModel.getCurrentOrders()
                    ?.let { initializeUI(LoadingState.LOADING, it) }

                LoadingState.ERROR -> ErrorScreen()
            }
        }
    }
}