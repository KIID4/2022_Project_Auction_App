package com.example.auction.app.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.auction.app.ui.shapes.*

@Composable
fun Login(){
    Column(
        Modifier.fillMaxSize(),
    ) {
        TopAppBar()
        LoginBox()
    }
}