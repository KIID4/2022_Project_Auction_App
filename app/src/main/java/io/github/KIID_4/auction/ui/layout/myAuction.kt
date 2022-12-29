package io.github.KIID_4.auction.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import io.github.KIID_4.auction.ui.shapes.myAuctionList
import io.github.KIID_4.auction.ui.shapes.topAppBar

@Composable
fun myAuctionProduct(navController: NavController) { // 나의 경매 물품 화면
    Column(
        Modifier.fillMaxSize(),
    ) {
        topAppBar(navController, true, "My")
        myAuctionList()
    }
}