package io.github.KIID_4.auction.ui.shapes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import io.github.KIID_4.auction.R // drawable에 있는 이미지 추가
import io.github.KIID_4.auction.ui.function.modifyToFirebase
import io.github.KIID_4.auction.ui.function.registerToFirebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
@Preview
fun mainButton() {
    Row(
        modifier = Modifier.padding(10.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        Button(onClick = { },
            modifier = Modifier.size(width = 100.dp, height = 100.dp).
            clip(CircleShape),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffAD55F2))
        ) {
            Text("온라인 경매", color = Color.White, fontSize = 17.sp, textAlign = TextAlign.Center)
        }

        Spacer(Modifier.weight(0.5f))

        Button(onClick = { },
            modifier = Modifier.size(width = 100.dp, height = 100.dp).
            clip(CircleShape),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffD1C0FF))
        ) {
            Text("물품 등록", color = Color.White, fontSize = 17.sp, textAlign = TextAlign.Center)
        }

        Spacer(Modifier.weight(0.5f))

        Button(onClick = { },
            modifier = Modifier.size(width = 100.dp, height = 100.dp).
            clip(CircleShape),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff888DFF))
        ) {
            Text("게시판", color = Color.White, fontSize = 17.sp, textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun myPageButton(navController : NavController) {
    Row(
        modifier = Modifier.padding(25.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        Column{
            Button(onClick = {
                navController.navigate("modifyingInfor")
            },
                modifier = Modifier.size(width = 70.dp, height = 70.dp).
                clip(CircleShape),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bill),
                    contentDescription = "bill",
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(Modifier.padding(7.dp))
            Text("정보 수정", fontSize = 17.sp)
        }


        Spacer(Modifier.padding(10.dp))

        Column{
            Button(onClick = { },
                modifier = Modifier.size(width = 70.dp, height = 70.dp).
                clip(CircleShape),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.attention),
                    contentDescription = "attention",
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(Modifier.padding(7.dp))
            Text("관심 물품", fontSize = 17.sp)
        }

        Spacer(Modifier.padding(10.dp))

        Column{
            Button(onClick = { },
                modifier = Modifier.size(width = 70.dp, height = 70.dp).
                clip(CircleShape),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.history),
                    contentDescription = "history",
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(Modifier.padding(7.dp))
            Text("거래 내역", fontSize = 17.sp)
        }


        Spacer(Modifier.padding(10.dp))

        Column{
            Button(onClick = { },
                modifier = Modifier.size(width = 70.dp, height = 70.dp).
                clip(CircleShape),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cart),
                    contentDescription = "cart",
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(Modifier.padding(7.dp))
            Text("경매 물품", fontSize = 17.sp, letterSpacing = 1.sp)
        }
    }
}

@Composable
@Preview
fun duplicationButton() {
    Button(onClick = { },
        modifier = Modifier.size(width = 80.dp, height = 30.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
    ) {
        Text("중복 확인", color = Color.White, fontSize = 10.sp)
    }
}

@Composable
fun registerButton(navController: NavController, email: String, passwd: String, toLoginScreen: () -> Unit) {
    val context = LocalContext.current
    val (registerSuccess, registersetSuccess) = remember { mutableStateOf(false) }

    if (registerSuccess) {
        navController.navigate("login")
        registersetSuccess(false)
    }

    Button(
        onClick = {
            if (email.isNotEmpty() && passwd.isNotEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    registerToFirebase(email, passwd, context) {
                        registersetSuccess(true)
                    }
                }
            }
        },

        modifier = Modifier.size(width = 80.dp, height = 40.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
    ) {
        Text("회원 가입", color = Color.White, fontSize = 10.sp)
    }
}

@Composable
fun modifiyButton(passwd: String, toMypageScreen: () -> Unit) {
    val context = LocalContext.current
    val (registerSuccess, setSuccess) = remember { mutableStateOf(false) }

    if (registerSuccess) {
        toMypageScreen()
    }

    Button(
        onClick = {
            if (passwd.isNotEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    modifyToFirebase(passwd, context) {
                        setSuccess(true)
                    }
                }
            }
        },
        modifier = Modifier.size(width = 80.dp, height = 40.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
    ) {
        Text("수정 완료", color = Color.White, fontSize = 10.sp)
    }
}