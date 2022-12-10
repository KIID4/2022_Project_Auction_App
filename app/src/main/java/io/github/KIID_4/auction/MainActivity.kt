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

                    composable("modifyingInfo") {
                        modifyingInfor(navController)
                    }

                    composable("regisProduct") {
                        regisProduct(navController)
                    }

                    composable("Auction") {
                        Auction(navController)
                    }

                    composable("printProductInfo") {
                        productInfo(navController)
                    }

                    composable("bulletin") {
                        bulletin(navController)
                    }

                    composable("bulletinLayout") {
                        bulletinLayout(navController)
                    }

                    composable("notice") {
                        notice(navController)
                    }

                    composable("NoticeLayout") {
                        NoticeLayout(navController)
                    }
                }
            }
        }
    }
}






