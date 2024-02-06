package com.sahaj.openinappassignment.ui.screens

import androidx.compose.foundation.background
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.sahaj.openinappassignment.Navigation
import com.sahaj.openinappassignment.R
import com.sahaj.openinappassignment.ui.theme.SecondaryBackground
import com.sahaj.openinappassignment.utils.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomAppBar {
                BottomNavigationBar(
                    items = listOf(
                        BottomNavItem(
                            name = "Links",
                            route = Routes.Dashboard.route,
                            icon = R.drawable.ic_link
                        ),
                        BottomNavItem(
                            name = "Courses",
                            route = Routes.CourseScreen.route,
                            icon = R.drawable.ic_courses
                        ),
                        BottomNavItem(
                            name = "Plus",
                            route = "",
                            icon = R.drawable.ic_plus
                        ),
                        BottomNavItem(
                            name = "Campaigns",
                            route = Routes.CampaignScreen.route,
                            icon = R.drawable.ic_campaigns
                        ),
                        BottomNavItem(
                            name = "Profile",
                            route = Routes.ProfileScreen.route,
                            icon = R.drawable.ic_profile
                        ),
                    ),
                    navController = navController,
                    onItemClick = {
                        navController.navigate(it.route)
                    }
                )
            }
        },
        modifier = Modifier.background(SecondaryBackground)
    ) {
        Navigation(navController = navController)
    }
}