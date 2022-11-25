package io.github.KIID_4.auction.ui.layout

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.KIID_4.auction.ui.shapes.*

@Composable
@Preview
fun myPage(){
    Column(
        Modifier.fillMaxSize(),
    ) {
        topAppBarPriview()
        myPageButton()
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            transsactionCount()
        }
    }
}