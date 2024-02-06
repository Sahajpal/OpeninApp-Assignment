package com.sahaj.openinappassignment.ui.screens.Dashboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.sahaj.openinappassignment.R
import com.sahaj.openinappassignment.models.Data
import com.sahaj.openinappassignment.models.Links
import com.sahaj.openinappassignment.ui.theme.Black
import com.sahaj.openinappassignment.ui.theme.BlueBorder
import com.sahaj.openinappassignment.ui.theme.LinkBlue
import com.sahaj.openinappassignment.ui.theme.PrimaryBackground
import com.sahaj.openinappassignment.ui.theme.TextGrey
import com.sahaj.openinappassignment.ui.theme.White
import com.sahaj.openinappassignment.ui.theme.figtree

@OptIn(ExperimentalFoundationApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun LinksTabView(tabName: List<String>, linksData: Data) {

    var links: ArrayList<Links>
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
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 22.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier
                .width(300.dp),
            containerColor = Color.Transparent,
            divider = {},
            indicator = {}
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
                            fontFamily = figtree
                        )
                    },
                    modifier = Modifier
                        .background(
                            shape = RoundedCornerShape(18.dp),
                            color = if (index == selectedTabIndex) {
                                PrimaryBackground
                            } else {
                                Color.Transparent
                            }
                        )
                )
            }
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search Button",
                tint = Color.Unspecified
            )
        }
    }
    HorizontalPager(state = pagerState, modifier = Modifier.padding(top = 48.dp, bottom = 20.dp)) {
        Card(
            modifier = Modifier
                .padding(top = 20.dp)
                .height(650.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(Color.Transparent)
        ) {
            LazyColumn(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                links = if (pagerState.currentPage == 0) {
                    linksData.topLinks
                } else {
                    linksData.recentLinks
                }
                items(links.size) {
                    Card(
                        modifier = Modifier
                            .height(76.dp)
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(White),
                        shape = RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            GlideImage(
                                model = links[it].originalImage,
                                contentDescription = "stacker",
                                modifier = Modifier
                                    .padding(end = 10.dp)
                                    .width(48.dp)
                                    .height(48.dp),
                                contentScale = ContentScale.FillBounds
                            )
                            Column(
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text(
                                    text = links[it].title.toString(), style = TextStyle(
                                        fontWeight = FontWeight(400),
                                        fontSize = 14.sp,
                                        color = Black,
                                        fontFamily = figtree
                                    ),
                                    modifier = Modifier.fillMaxWidth(0.7f),
                                    maxLines = 1,
                                    softWrap = true,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = "22 Aug 2022", style = TextStyle(
                                        fontWeight = FontWeight(400),
                                        fontSize = 12.sp,
                                        color = TextGrey,
                                        fontFamily = figtree
                                    )
                                )
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Column(
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text(
                                    text = links[it].totalClicks.toString(), style = TextStyle(
                                        fontWeight = FontWeight(400),
                                        fontSize = 14.sp,
                                        color = Black,
                                        fontFamily = figtree
                                    )
                                )
                                Text(
                                    text = "Clicks", style = TextStyle(
                                        fontWeight = FontWeight(400),
                                        fontSize = 12.sp,
                                        color = TextGrey,
                                        fontFamily = figtree
                                    )
                                )
                            }
                        }
                    }
                    val stroke = Stroke(
                        width = 2f,
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                    )
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                            .background(
                                color = LinkBlue,
                                RoundedCornerShape(0.dp, 0.dp, 8.dp, 8.dp)
                            )
                            .drawBehind {
                                drawRoundRect(
                                    color = BlueBorder,
                                    style = stroke,
                                    cornerRadius = CornerRadius(8.dp.toPx(), 8.dp.toPx()),
                                )
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(horizontal = 12.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = links[it].webLink.toString(),
                                style = TextStyle(
                                    fontWeight = FontWeight(400),
                                    fontSize = 14.sp,
                                    color = PrimaryBackground,
                                    fontFamily = figtree
                                ),
                                modifier = Modifier.fillMaxWidth(0.8f),
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1,
                                softWrap = true,
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_copylink),
                                contentDescription = "Copy icon",
                                tint = Color.Unspecified
                            )
                        }
                    }
                }
            }
        }
    }
}