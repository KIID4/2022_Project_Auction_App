package io.github.KIID_4.auction.ui.layout

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import io.github.KIID_4.auction.ui.shapes.*

@Composable
@Preview
fun myPage() {
    val user = Firebase.auth.currentUser
    if (user != null) {
        // User is signed in
    } else {
        // No user is signed in
    }

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