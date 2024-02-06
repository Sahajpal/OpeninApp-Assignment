package com.sahaj.openinappassignment.ui.screens.Dashboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sahaj.openinappassignment.ui.theme.PrimaryBackground
import com.sahaj.openinappassignment.ui.theme.TextGrey
import com.sahaj.openinappassignment.ui.theme.White

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LinksTabView(tabName: List<String>) {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    val pagerState = rememberPagerState {
        tabName.size
    }
    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }
    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        contentColor = PrimaryBackground
    ) {
        tabName.forEachIndexed { index, name ->
            Tab(
                selected = index == selectedTabIndex,
                onClick = {
                    selectedTabIndex = index
                },
                text = {
                    Text(
                        text = name,
                        color = if (index == selectedTabIndex) {
                            White
                        } else {
                            TextGrey
                        },
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                    )
                }
            )
        }
        HorizontalPager(state = pagerState) { index ->
            Card(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .background(
                        color = Color.Transparent,
                        shape = RoundedCornerShape(size = 24.dp)
                    )
                    .height(310.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "HI")
            }
        }
    }
}