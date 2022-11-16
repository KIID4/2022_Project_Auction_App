package com.example.auction.app.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.auction.app.ui.shapes.PopularPreview
import com.example.auction.app.ui.shapes.*

@Composable
@Preview
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
