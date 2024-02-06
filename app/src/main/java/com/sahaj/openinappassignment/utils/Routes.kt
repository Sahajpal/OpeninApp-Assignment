package com.sahaj.openinappassignment.utils

sealed class Routes(val route: String) {
    object Dashboard : Routes("dashboard_screen")
}