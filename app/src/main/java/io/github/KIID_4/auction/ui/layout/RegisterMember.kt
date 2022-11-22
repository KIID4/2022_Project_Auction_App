package io.github.KIID_4.auction.ui.layout
import android.graphics.Paint.Align
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import io.github.KIID_4.auction.ui.shapes.*


@Composable
fun RegisterMember(navController : NavController){
    TopAppBar(navController)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        JoinMember()
    }
}

@Composable
@Preview
fun RegisterMember22(){
    TopAppBarPriview()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        JoinMember()
    }
}