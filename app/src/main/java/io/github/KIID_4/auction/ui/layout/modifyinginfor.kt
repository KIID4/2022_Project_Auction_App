package io.github.KIID_4.auction.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import io.github.KIID_4.auction.ui.shapes.modifiymember
import io.github.KIID_4.auction.ui.shapes.topAppBar

@Composable
fun modifyingInfor(navController : NavController) { // 정보 수정 화면
    topAppBar(navController, true, "Logout")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        modifiymember(navController)
    }
}

