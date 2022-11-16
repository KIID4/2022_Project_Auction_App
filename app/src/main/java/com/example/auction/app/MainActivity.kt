package com.example.auction.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.tooling.preview.Preview
import com.example.auction.app.ui.layout.*
import com.example.auction.app.ui.theme.AuctionAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuctionAppTheme {
                // A surface container using the 'background' color from the theme
                // Compose의 경우 상태가 바뀔때마다 Recompose를 사용하게 되는데 setContent블록을 처음부터 다시 수행함
                UserMain()
                //Login()
            }
        }
    }
}






