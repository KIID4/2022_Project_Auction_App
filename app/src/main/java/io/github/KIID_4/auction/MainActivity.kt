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
                    composable("userMain") { // 메인화면
                        userMain(navController)
                    }

                    composable("login") { // 로그인 화면
                        login(navController)
                    }

                    composable("registerMember") { // 회원가입 화면
                        registerMember(navController)
                    }

                    composable("myPage") { // 마이페이지 화면
                        myPage(navController)
                    }

                    composable("modifyingInfo") { // 정보 수정화면
                        modifyingInfor(navController)
                    }

                    composable("regisProduct") { // 물품 등록 화면
                        regisProduct(navController)
                    }

                    composable("auction") { // 경매 물품 리스트 화면
                        auction(navController)
                    }

                    composable("ProductInfo") { // 물품 정보 출력 화면
                        productInfo(navController)
                    }

                    composable("bulletin") { // 게시글 리스트 화면
                        bulletin(navController)
                    }

                    composable("bulletinLayout") { // 게시글 작성 화면
                        bulletinLayout(navController)
                    }

                    composable("bulletinInfo") { // 게시글 세부 내용
                        bulletinInfo(navController)
                    }

                    composable("notice") { // 공지사항 리스트 화면
                        notice(navController)
                    }

                    composable("noticeLayout") { // 공지사항 작성 화면
                        noticeLayout(navController)
                    }

                    composable("noticeInfo") { // 공지사항 세부 내용
                        noticeInfo(navController)
                    }

                    composable("tender") { // 입찰 화면
                        tender(navController)
                    }

                    composable("myAuctionProduct") {
                        myAuctionProduct(navController)
                    }

                    composable("searchProduct") {
                        searchProduct(navController)
                    }
                }
            }
        }
    }
}






