package com.example.auction.app.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.auction.app.ui.shapes.PopularPreview
import com.example.auction.app.ui.shapes.*

@Composable
fun UserMain() {
    Column(
        Modifier.fillMaxSize()
    ) {
        TopAppBar()
        NoticePreview()
        Buttons()
        PopularPreview()
    }
}
