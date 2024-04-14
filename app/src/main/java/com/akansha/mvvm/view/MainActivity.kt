package com.akansha.mvvm.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import com.akansha.mvvm.model.LoadingState
import com.akansha.mvvm.model.Order
import com.akansha.mvvm.ui.theme.MvvmTheme
import com.akansha.mvvm.view.design.ErrorScreen
import com.akansha.mvvm.view.design.MainScreen
import com.akansha.mvvm.view.design.ProgressScreen
import com.akansha.mvvm.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onResume() {
        super.onResume()
        initializeObservers()
        viewModel.onViewReady()
    }

    private fun initializeUI(orders: List<Order>) {
        setContent {
            MainScreen(orders, onSearchTextChanged = { viewModel.onSearchQuery(it) })
        }
    }

    private fun initializeObservers() {
        viewModel.loadingStateLiveData.observe(this, Observer {
            onLoadingStateChanged(it)
        })
        viewModel.ordersLiveData.observe(this, Observer {
            initializeUI(it)
        })
    }

    private fun onLoadingStateChanged(state: LoadingState) {
        setContent {
            when (state) {
                LoadingState.LOADED -> viewModel.getCurrentOrders()?.let { initializeUI(it) }
                LoadingState.LOADING -> ProgressScreen()
                LoadingState.ERROR -> ErrorScreen()
            }
        }
    }
}