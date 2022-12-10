package io.github.KIID_4.auction.ui.layout
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import io.github.KIID_4.auction.ui.shapes.*


@Composable
fun registerMember(navController : NavController) {
    topAppBar(navController, true, "My")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        joinMember(navController)
    }
}
