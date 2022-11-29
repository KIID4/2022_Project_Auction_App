package io.github.KIID_4.auction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.KIID_4.auction.ui.theme.AuctionAppTheme
import io.github.KIID_4.auction.ui.layout.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuctionAppTheme {
                val navController = rememberNavController()  // 화면이동 담당 객체

                NavHost(
                    navController = navController,
                    startDestination = "userMain"
                ) {
                    composable("userMain") {
                        userMain(navController)
                    }

                    composable("login") {
                        login(navController)
                    }

                    composable("registerMember") {
                        registerMember(navController)
                    }

                    composable("myPage") {
                        myPage(navController)
                    }

                    composable("modifyingInfor") {
                        modifyingInfor(navController)
                    }
                }
                // A surface container using the 'background' color from the theme
                // Compose의 경우 상태가 바뀔때마다 Recompose를 사용하게 되는데 setContent블록을 처음부터 다시 수행함
            }
        }
    }
}






