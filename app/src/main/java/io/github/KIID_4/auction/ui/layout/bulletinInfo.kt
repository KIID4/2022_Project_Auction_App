package io.github.KIID_4.auction.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import io.github.KIID_4.auction.ui.shapes.printBulletinInfo
import io.github.KIID_4.auction.ui.shapes.topAppBar


@Composable
fun bulletinInfo(navController: NavController) {
    Column(
        Modifier.fillMaxSize()
    ) {
        topAppBar(navController, true, "My")
        printBulletinInfo()
    }
}