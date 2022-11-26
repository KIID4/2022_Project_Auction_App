package io.github.KIID_4.auction.ui.shapes

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import io.github.KIID_4.auction.ui.function.loginToFirebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun loginBox(navController : NavController) {
    val context = LocalContext.current
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically  // Text 위젯들 간 세로 중앙 정렬 위함
    )  {
        val (emailID, setEmailID) = remember { mutableStateOf(TextFieldValue()) }
        val (passWD, setPassWD) = remember { mutableStateOf(TextFieldValue()) }
        val (loginSuccess, setSuccess) = remember { mutableStateOf(false) }

        if (loginSuccess) {
            navController.navigate("mainScreen")
        }

        Column(Modifier.padding(20.dp)){
            iDBar(emailID, setEmailID)
            Spacer(Modifier.padding(1.dp))
            passwordBar(passWD, setPassWD)
            Spacer(Modifier.padding(10.dp))
            Button(onClick = {
                if (emailID.text.isNotEmpty() && passWD.text.isNotEmpty()) {
                    CoroutineScope(Dispatchers.IO).launch {
                        loginToFirebase(emailID.text, passWD.text, context) {
                            setSuccess(true)
                        }
                    }
                }
            },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff070000))
            ) {
                Text("로그인", color = Color.White, fontSize = 17.sp, textAlign = TextAlign.Center)
            }

            Button(onClick = {
                navController.navigate("RegisterMember")
            },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff070000))
            ) {
                Text("회원가입", color = Color.White, fontSize = 17.sp, textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
@Preview
fun loginBoxPreview() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically  // Text 위젯들 간 세로 중앙 정렬 위함
    )  {
        var (emailID, setEmailID) = remember { mutableStateOf(TextFieldValue()) }
        var (passWD, setPassWD) = remember { mutableStateOf(TextFieldValue()) }

        Column(Modifier.padding(20.dp)){
            iDBar(emailID, setEmailID)
            Spacer(Modifier.padding(1.dp))
            passwordBar(passWD, setPassWD)
            Spacer(Modifier.padding(10.dp))
            Button(onClick = { },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff070000))
            ) {
                Text("로그인", color = Color.White, fontSize = 17.sp, textAlign = TextAlign.Center)
            }

            Button(onClick = { },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff070000))
            ) {
                Text("회원가입", color = Color.White, fontSize = 17.sp, textAlign = TextAlign.Center)
            }
        }
    }
}