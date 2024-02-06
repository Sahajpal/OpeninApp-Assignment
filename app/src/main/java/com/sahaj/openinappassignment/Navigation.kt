package com.sahaj.openinappassignment

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sahaj.openinappassignment.ui.screens.Dashboard.Dashboard
import com.sahaj.openinappassignment.utils.Routes
import com.sahaj.openinappassignment.viewModels.DashboardViewModel
import kotlinx.coroutines.runBlocking

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val dashboardViewModel = viewModel<DashboardViewModel>()

    NavHost(navController = navController, startDestination = Routes.Dashboard.route) {
        composable(Routes.Dashboard.route) {
            runBlocking {
                dashboardViewModel.getDashboardData()
            }
            Dashboard(dashboardViewModel = dashboardViewModel)
        }

        // Expand on this nav graph for future screens and implementations
    }
}