package io.github.KIID_4.auction.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import io.github.KIID_4.auction.ui.shapes.popularPreview
import io.github.KIID_4.auction.ui.shapes.*

@Composable
fun userMain(navController : NavController) {
    val user = Firebase.auth.currentUser
    if (user != null) {
        // User is signed in
    } else {
        // No user is signed in
    }

    Column(
        Modifier.fillMaxSize()
    ) {
        topAppBar(navController, true)
        noticePreview()
        mainButton()
        popularPreview()
    }
}
