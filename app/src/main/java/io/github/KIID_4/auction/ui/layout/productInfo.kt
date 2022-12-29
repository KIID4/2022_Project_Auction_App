package io.github.KIID_4.auction.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import io.github.KIID_4.auction.ui.shapes.printProductInfo
import io.github.KIID_4.auction.ui.shapes.topAppBar

@Composable
fun productInfo(navController: NavHostController) { // 물품 정보 출력 화면
    Column(
        Modifier.fillMaxSize()
    ) {
        topAppBar(navController, true, "My")
        printProductInfo(navController)
    }
}