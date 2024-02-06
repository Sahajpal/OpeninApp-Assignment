package com.sahaj.openinappassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.sahaj.openinappassignment.ui.screens.MainScreen
import com.sahaj.openinappassignment.ui.theme.OpeninAppAssignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //For future modifications we can include different themes and options for the app
            OpeninAppAssignmentTheme {
                Surface {
                    MainScreen()
                }
            }
        }
    }
}