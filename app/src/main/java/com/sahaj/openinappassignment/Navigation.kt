package com.sahaj.openinappassignment

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sahaj.openinappassignment.ui.screens.Dashboard.Dashboard
import com.sahaj.openinappassignment.ui.screens.Future.Campaigns
import com.sahaj.openinappassignment.ui.screens.Future.Courses
import com.sahaj.openinappassignment.ui.screens.Future.Profile
import com.sahaj.openinappassignment.utils.Routes
import com.sahaj.openinappassignment.viewModels.DashboardViewModel

@Composable
fun Navigation(navController: NavHostController) {
    val dashboardViewModel = viewModel<DashboardViewModel>()

    NavHost(navController = navController, startDestination = Routes.Dashboard.route) {
        composable(Routes.Dashboard.route) {
            Dashboard(dashboardViewModel = dashboardViewModel)
        }

        // Expand on this nav graph for future screens and implementations
        composable(Routes.CourseScreen.route) {
            Courses()
        }
        composable(Routes.CampaignScreen.route) {
            Campaigns()
        }
        composable(Routes.ProfileScreen.route) {
            Profile()
        }
    }
}