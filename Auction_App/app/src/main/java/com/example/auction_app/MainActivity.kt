package com.example.auction_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.au.TopAppBar
import com.example.auction_app.ui.theme.Auction_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Auction_AppTheme {
                // A surface container using the 'background' color from the theme
                // Compose의 경우 상태가 바뀔때마다 Recompose를 사용하게 되는데 setContent블록을 처음부터 다시 수행함
                TopAppBar()
                MiddleButtons()
                LastProducts()
            }
        }
    }
}






