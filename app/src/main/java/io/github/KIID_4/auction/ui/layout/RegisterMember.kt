package io.github.KIID_4.auction.app.ui.layout
import android.graphics.Paint.Align
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.KIID_4.auction.ui.shapes.*


@Composable
@Preview
fun RegisterMember(){
    TopAppBarTest()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        JoinMember()
    }
}