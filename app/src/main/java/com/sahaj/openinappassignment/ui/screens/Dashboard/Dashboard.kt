package com.sahaj.openinappassignment.ui.screens.Dashboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sahaj.openinappassignment.R
import com.sahaj.openinappassignment.ui.theme.Black
import com.sahaj.openinappassignment.ui.theme.BlueBorder
import com.sahaj.openinappassignment.ui.theme.ButtonGrey
import com.sahaj.openinappassignment.ui.theme.GreenBorder
import com.sahaj.openinappassignment.ui.theme.LinkBlue
import com.sahaj.openinappassignment.ui.theme.PrimaryBackground
import com.sahaj.openinappassignment.ui.theme.SecondaryBackground
import com.sahaj.openinappassignment.ui.theme.TextGrey
import com.sahaj.openinappassignment.ui.theme.WhatsappGreen
import com.sahaj.openinappassignment.ui.theme.White
import com.sahaj.openinappassignment.viewModels.DashboardViewModel
import kotlinx.coroutines.runBlocking

@Composable
fun Dashboard(dashboardViewModel: DashboardViewModel) {
    val dashboardData = dashboardViewModel.dashboardResponse.value

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Box(modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(124.dp)
                        .background(color = PrimaryBackground)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Dashboard", style = TextStyle(
                                fontWeight = FontWeight(600),
                                fontSize = 24.sp,
                                color = White
                            )
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 100.dp)
                        .background(
                            color = SecondaryBackground,
                            shape = RoundedCornerShape(16.dp, 16.dp, 0.dp, 0.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 24.dp)
                    ) {
                        Text(
                            text = "Good Morning", style = TextStyle(
                                fontWeight = FontWeight(400),
                                fontSize = 16.sp,
                                color = TextGrey
                            )
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Sahaj PSM", style = TextStyle(
                                    fontWeight = FontWeight(600),
                                    fontSize = 24.sp,
                                    color = Black
                                ),
                                modifier = Modifier
                                    .padding(end = 8.dp)
                            )
                            Image(
                                painter = painterResource(id = R.drawable.ic_waving),
                                contentDescription = "Waving emoji",
                                modifier = Modifier
                                    .height(28.dp)
                                    .width(28.dp)
                            )
                        }
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .padding(vertical = 20.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = CardDefaults.cardColors(containerColor = White)
                        ) {
                            //Todo
                        }
                        LazyRow(
                            modifier = Modifier
                                .padding(bottom = 20.dp)
                        ) {
                            items(4) {
                                Card(
                                    modifier = Modifier
                                        .padding(end = 20.dp)
                                        .height(120.dp)
                                        .width(120.dp),
                                    shape = RoundedCornerShape(8.dp),
                                    colors = CardDefaults.cardColors(containerColor = White)
                                ) {

                                }
                            }
                        }
                        OutlinedButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(width = 1.dp, color = ButtonGrey)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_crooked_arrow),
                                contentDescription = "Analytics button icon",
                                Modifier.padding(end = 8.dp),
                                tint = Black
                            )
                            Text(
                                text = "View Analytics", style = TextStyle(
                                    fontWeight = FontWeight(600),
                                    fontSize = 16.sp,
                                    color = Black
                                )
                            )
                        }

                        val tabs = listOf("Top Links", "Recent Links")
//                        LinksTabView(tabName = tabs)

                        OutlinedButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(width = 1.dp, color = ButtonGrey)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_link),
                                contentDescription = "Link Icon",
                                Modifier.padding(end = 8.dp),
                                tint = Black
                            )
                            Text(
                                text = "View all Links", style = TextStyle(
                                    fontWeight = FontWeight(600),
                                    fontSize = 16.sp,
                                    color = Black
                                )
                            )
                        }
                        OutlinedButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .padding(bottom = 20.dp, top = 40.dp)
                                .fillMaxWidth()
                                .height(64.dp),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(width = 1.dp, color = GreenBorder),
                            colors = ButtonDefaults.buttonColors(containerColor = WhatsappGreen)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_whatsapp),
                                contentDescription = "Whatsapp Icon",
                                Modifier.padding(end = 16.dp),
                                tint = Color(0xFF4AD15F)
                            )
                            Text(
                                text = "Talk with us", style = TextStyle(
                                    fontWeight = FontWeight(600),
                                    fontSize = 16.sp,
                                    color = Black
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                        OutlinedButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(64.dp),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(width = 1.dp, color = BlueBorder),
                            colors = ButtonDefaults.buttonColors(containerColor = LinkBlue),
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_faq),
                                contentDescription = "FAQ icon",
                                Modifier.padding(end = 16.dp),
                                tint = Color(0xFF0E6FFF)
                            )
                            Text(
                                text = "Frequently Asked Questions", style = TextStyle(
                                    fontWeight = FontWeight(600),
                                    fontSize = 16.sp,
                                    color = Black
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            }
        }
    }
}