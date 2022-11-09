package com.example.auction.app.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.auction.app.ui.shapes.LastProducts
import com.example.auction.app.ui.shapes.MiddleButtons
import com.example.auction.app.ui.shapes.TopAppBar
import io.github.untactorder.toasterAtSnackBar.InjectableSnackBar

@Composable
fun UserMain() {
    val injector = InjectableSnackBar()
    injector.FloatingSnackBar(snackBarAlignment = Alignment.Center) {
        Column(Modifier.fillMaxSize()) {
            TopAppBar(injector)
            MiddleButtons(injector)
            LastProducts(injector)
        }
    }
}