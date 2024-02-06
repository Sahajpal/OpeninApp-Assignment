package com.sahaj.openinappassignment.viewModels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sahaj.openinappassignment.data.repository.Repository
import com.sahaj.openinappassignment.models.DashboardResponse
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class DashboardViewModel: ViewModel() {
    private val repository = Repository()
    var dashboardResponse = mutableStateOf(DashboardResponse())
        private set
    init {
        getDashboardData()
    }
    private fun getDashboardData() {
        viewModelScope.launch {
            try {
                val getResponse = async { repository.getDashboardData() }
                dashboardResponse.value = getResponse.await()
            } catch (e: Exception) {
                Log.e("Error", e.toString())
            }
        }
    }
}