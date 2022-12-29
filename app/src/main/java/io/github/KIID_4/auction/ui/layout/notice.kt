package io.github.KIID_4.auction.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import io.github.KIID_4.auction.ui.shapes.noticeList
import io.github.KIID_4.auction.ui.shapes.topAppBar

@Composable
fun notice(navController: NavController) { // 공지사항 리스트 화면
    Column(
        Modifier.fillMaxSize(),
    ) {
        topAppBar(navController, true, "My")
        noticeList(navController)
    }
}