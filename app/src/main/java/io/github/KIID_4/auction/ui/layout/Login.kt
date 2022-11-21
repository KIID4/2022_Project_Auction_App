package io.github.KIID_4.auction.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import io.github.KIID_4.auction.ui.shapes.*

@Composable
fun Login(navController : NavController){
    Column(
        Modifier.fillMaxSize(),
    ) {
        TopAppBar(navController)
        LoginBox(navController)
    }
}