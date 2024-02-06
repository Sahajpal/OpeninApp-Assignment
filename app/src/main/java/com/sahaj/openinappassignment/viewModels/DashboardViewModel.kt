package com.sahaj.openinappassignment.viewModels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sahaj.openinappassignment.data.repository.Repository
import com.sahaj.openinappassignment.models.DashboardResponse
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class DashboardViewModel: ViewModel() {
    private val repository = Repository()
    var dashboardResponse = mutableStateOf(DashboardResponse())
        private set

    suspend fun getDashboardData() = coroutineScope {
        try {
            val getResponse = async { repository.getDashboardData() }
            dashboardResponse.value = getResponse.await()
            Log.d("heheheh", dashboardResponse.toString())
        } catch (e: Exception) {
            Log.e("Fetch User", e.toString())
        }
    }
}