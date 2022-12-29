package io.github.KIID_4.auction.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import io.github.KIID_4.auction.ui.shapes.tenderDisplay
import io.github.KIID_4.auction.ui.shapes.topAppBar

@Composable
fun tender(navController: NavHostController) { // 입찰 화면

    Column(
        Modifier.fillMaxSize()
    ) {
        topAppBar(navController, true, "My")
        tenderDisplay(navController)
    }
}