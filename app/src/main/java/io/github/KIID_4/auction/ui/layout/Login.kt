package io.github.KIID_4.auction.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import io.github.KIID_4.auction.ui.shapes.*

@Composable
fun login(navController : NavController){
    Column(
        Modifier.fillMaxSize(),
    ) {
        topAppBar(navController)
        loginBox(navController)
    }
}