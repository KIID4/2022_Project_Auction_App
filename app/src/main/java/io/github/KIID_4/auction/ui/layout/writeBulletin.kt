package io.github.KIID_4.auction.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import io.github.KIID_4.auction.ui.shapes.topAppBar
import io.github.KIID_4.auction.ui.shapes.writeBulletin

@Composable
fun bulletinLayout(navController: NavController) { // 게시글 작성 화면
    Column(
        Modifier.fillMaxSize(),
    ) {
        topAppBar(navController, true, "My")
        writeBulletin(navController)
    }
}