package io.github.KIID_4.auction.ui.layout

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import io.github.KIID_4.auction.ui.shapes.*

@Composable
fun myPage(navController : NavController) {
    val user = Firebase.auth.currentUser // 유저 정보를 불러옴

    if (user != null) {
        // User is signed in
    } else {
        // No user is signed in
    }

    Column(
        Modifier.fillMaxSize(),
    ) {
        topAppBar(navController, false)
        myPageButton(navController)
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            transsactionCount()
        }
    }
}