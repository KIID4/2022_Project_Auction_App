package io.github.KIID_4.auction.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import io.github.KIID_4.auction.ui.shapes.printNoticeInfo
import io.github.KIID_4.auction.ui.shapes.topAppBar

@Composable
fun noticeInfo(navController: NavController) { // 공지사항 세부 내용
    Column(
        Modifier.fillMaxSize()
    ) {
        topAppBar(navController, true, "My")
        printNoticeInfo()
    }
}