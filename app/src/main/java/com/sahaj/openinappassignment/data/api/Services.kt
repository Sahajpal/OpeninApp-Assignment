package com.sahaj.openinappassignment.data.api

import com.sahaj.openinappassignment.data.Constants
import com.sahaj.openinappassignment.models.DashboardResponse
import retrofit2.http.GET

interface Services {
    @GET(Constants.DASHBOARD_DATA)
    suspend fun getDashboardData(): DashboardResponse
}