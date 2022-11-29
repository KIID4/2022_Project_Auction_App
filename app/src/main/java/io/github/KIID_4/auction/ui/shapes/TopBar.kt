package io.github.KIID_4.auction.ui.shapes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


@Composable
fun topAppBar(navController: NavController, use: Boolean, check : String) {
    val user = Firebase.auth.currentUser

    var userName = "로그인이 필요합니다"
    if (user != null) {
        userName = user.uid
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color(0xff4E7FFF)
    )  {
        Column(Modifier.padding(10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically  // Text 위젯들 간 세로 중앙 정렬 위함
            ) {
                Text(text = userName, color = Color.White, fontSize = 18.sp)
                Spacer(Modifier.weight(1.0f))
                if (check == "My") {
                    Text(text = "My", color = Color.White, fontSize = 20.sp, modifier = Modifier
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null, // 버튼 중복 방지
                            enabled = use,
                            onClickLabel = null,
                            role = null,
                            onClick = {
                                if (user != null) {
                                    navController.navigate("myPage")
                                } else {
                                    navController.navigate("Login")
                                }
                            }
                        )
                    )
                }

                else if (check == "Logout") {
                    Text(text = "Logout", color = Color.White, fontSize = 20.sp, modifier = Modifier
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null, // 버튼 중복 방지
                            enabled = true,
                            onClickLabel = null,
                            role = null,
                            onClick = {
                                FirebaseAuth.getInstance().signOut()
                                navController.navigate("userMain")
                            }
                        )
                    )
                }

            }
            Spacer(Modifier.padding(6.dp))
            searchBar()
        }
    }
}