package io.github.KIID_4.auction.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import io.github.KIID_4.auction.ui.shapes.Modifiymember
import io.github.KIID_4.auction.ui.shapes.topAppBar

@Composable
fun Modifyinginfor(navController : NavController) {
    topAppBar(navController, true)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Modifiymember {
            navController.navigate("Mypage")
        }
    }
}