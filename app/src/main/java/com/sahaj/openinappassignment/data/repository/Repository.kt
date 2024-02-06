package com.sahaj.openinappassignment.data.repository

import com.sahaj.openinappassignment.data.RetrofitInstance
import com.sahaj.openinappassignment.models.DashboardResponse

class Repository {
    private val services = RetrofitInstance.services

    suspend fun getDashboardData(): DashboardResponse {
        return services.getDashboardData()
    }
}