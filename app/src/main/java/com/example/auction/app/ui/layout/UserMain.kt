package com.example.auction.app.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.auction.app.ui.shapes.PopularPreview
import com.example.auction.app.ui.shapes.*

@Composable
@Preview
fun UserMain(navController : NavController) {
    Column(
        Modifier.fillMaxSize()
    ) {
        TopAppBar(navController)
        NoticePreview()
        MainButton()
        PopularPreview()
    }
}
