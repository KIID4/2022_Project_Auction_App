package io.github.KIID_4.auction.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import io.github.KIID_4.auction.ui.shapes.galleryImage
import io.github.KIID_4.auction.ui.shapes.topAppBar


@Composable
fun regisProduct(navController: NavHostController) { // 물품 등록 화면

    Column(
        Modifier.fillMaxSize()
    ) {
        topAppBar(navController, true, "My")
        galleryImage(navController)
    }
}