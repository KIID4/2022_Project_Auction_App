package io.github.KIID_4.auction.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import io.github.KIID_4.auction.ui.shapes.popularPreview
import io.github.KIID_4.auction.ui.shapes.*

@Composable
fun userMain(navController : NavController) {
    val user = Firebase.auth.currentUser

    if(user != null) {
        Column(
            Modifier.fillMaxSize()
        ) {
            topAppBar(navController, true, "My")
            noticePreview()
            mainButton()
            popularPreview()
        }
    }
    else {
        Column(
            Modifier.fillMaxSize()
        ) {
            topAppBar(navController, true, "My")
            noticePreview()
            mainButton()
            popularPreview()
        }
    }



}
