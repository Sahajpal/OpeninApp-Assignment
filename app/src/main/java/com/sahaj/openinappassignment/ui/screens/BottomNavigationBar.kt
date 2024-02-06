package com.sahaj.openinappassignment.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.sahaj.openinappassignment.R
import com.sahaj.openinappassignment.ui.theme.Black
import com.sahaj.openinappassignment.ui.theme.PrimaryBackground
import com.sahaj.openinappassignment.ui.theme.TextGrey
import com.sahaj.openinappassignment.ui.theme.White
import com.sahaj.openinappassignment.ui.theme.figtree

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: Int
)

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    NavigationBar(
        modifier = modifier,
        containerColor = White,
        tonalElevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            NavigationBarItem(
                selected = selected,
                onClick = { onItemClick(item) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Black,
                    unselectedIconColor = TextGrey,
                    indicatorColor = White
                ),
                icon = {
                    if (item.name == "Plus") {
                        FloatingActionButton(
                            onClick = { /*TODO*/ },
                            shape = RoundedCornerShape(100.dp),
                            containerColor = PrimaryBackground
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_plus),
                                contentDescription = "plus icon",
                                tint = White
                            )
                        }
                    } else {
                        Column(horizontalAlignment = CenterHorizontally) {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.name,
                                modifier = Modifier.padding(bottom = 6.dp)
                            )
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 11.sp,
                                fontWeight = FontWeight(600),
                                fontFamily = figtree
                            )
                        }
                    }
                },
            )
        }
    }
}