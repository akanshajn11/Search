package com.akansha.mvvm.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akansha.mvvm.model.LoadingState
import com.akansha.mvvm.model.Order
import com.akansha.mvvm.model.OrderDataGenerator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel : ViewModel() {

    val ordersLiveData = MediatorLiveData<List<Order>>()
    private val _queryLiveData = MutableLiveData<String>()
    private val _allOrdersLiveData = MutableLiveData<List<Order>>()
    private val _searchOrdersLiveData = MutableLiveData<List<Order>>()
    val loadingStateLiveData = MutableLiveData<LoadingState>()

    init {
        ordersLiveData.addSource(_allOrdersLiveData) {
            ordersLiveData.value = it
        }
        ordersLiveData.addSource(_searchOrdersLiveData) {
            ordersLiveData.value = it
        }
    }

    fun onSearchQuery(query: String) {}

    fun getCurrentOrders(): List<Order>? = ordersLiveData.value

    fun onViewReady() {
        if (_allOrdersLiveData.value.isNullOrEmpty()) {
            fetchAllOrders()
        }
    }

    private fun fetchAllOrders() {
        loadingStateLiveData.value = LoadingState.LOADING
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val orders = OrderDataGenerator.getAllOrders()
                _allOrdersLiveData.postValue(orders)
                loadingStateLiveData.postValue(LoadingState.LOADED)
            } catch (e: Exception) {
                loadingStateLiveData.postValue(LoadingState.ERROR)
            }
        }
    }
}