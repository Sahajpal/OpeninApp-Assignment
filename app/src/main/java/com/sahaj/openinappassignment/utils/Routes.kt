package com.sahaj.openinappassignment.utils

sealed class Routes(val route: String) {
    object Dashboard : Routes("dashboard_screen")
    object CourseScreen : Routes("courses_screen")
    object CampaignScreen : Routes("campaign_screen")
    object ProfileScreen : Routes("profile_screen")
}