package com.sahaj.openinappassignment.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sahaj.openinappassignment.R

val figtree = FontFamily(
    listOf(
        Font(R.font.figtree_regular, FontWeight.Normal),
        Font(R.font.figtree_medium, FontWeight.Medium),
        Font(R.font.figtree_semibold, FontWeight.SemiBold),
        Font(R.font.figtree_bold, FontWeight.Bold),
        Font(R.font.figtree_black, FontWeight.Black),
        Font(R.font.figtree_light, FontWeight.Light)
    )
)
// Would have used the typography but would have taken a lot of time to study and tally the sizes for each classification
val Typography = Typography(
    //TODO
)