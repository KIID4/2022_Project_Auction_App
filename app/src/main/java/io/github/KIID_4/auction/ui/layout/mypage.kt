package io.github.KIID_4.auction.ui.layout

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import io.github.KIID_4.auction.ui.shapes.*

@Composable
fun myPage(navController : NavController) { // 마이페이지 화면
    Column(
        Modifier.fillMaxSize(),
    ) {
        topAppBar(navController, false, "Logout")
        myPageButton(navController)
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            transsactionCount()
        }
        saleList()
    }
}