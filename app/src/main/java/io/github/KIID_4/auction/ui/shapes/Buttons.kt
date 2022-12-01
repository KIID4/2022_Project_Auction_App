package io.github.KIID_4.auction.ui.shapes


import android.graphics.Bitmap
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import io.github.KIID_4.auction.R
import io.github.KIID_4.auction.ui.function.modifyToFirebase
import io.github.KIID_4.auction.ui.function.registerToFirebase
import io.github.KIID_4.auction.ui.function.upLoadToFirebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun mainButton(navController: NavController) {
    val user = Firebase.auth.currentUser
    var check = false

    if (user != null) {
        check = true
    }
    Row(
        modifier = Modifier.padding(10.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        Button(onClick = { },
            modifier = Modifier.size(width = 100.dp, height = 100.dp).
            clip(CircleShape),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffAD55F2)),
            enabled = check
        ) {
            Text("온라인 경매", color = Color.White, fontSize = 17.sp, textAlign = TextAlign.Center)
        }

        Spacer(Modifier.weight(0.5f))

        Button(onClick = {
            navController.navigate("regisProduct")
        },
            modifier = Modifier.size(width = 100.dp, height = 100.dp).
            clip(CircleShape),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffD1C0FF)),
            enabled = check
        ) {
            Text("물품 등록", color = Color.White, fontSize = 17.sp, textAlign = TextAlign.Center)
        }

        Spacer(Modifier.weight(0.5f))

        Button(onClick = { },
            modifier = Modifier.size(width = 100.dp, height = 100.dp).
            clip(CircleShape),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff888DFF)),
            enabled = check
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
fun registerButton(
    navController: NavController,
    email: String,
    passwd: String,
    name: String,
    callNum: String,
    birthday: String,
    toLoginScreen: () -> Unit
) {
    val context = LocalContext.current
    val (registerSuccess, registerSetSuccess) = remember { mutableStateOf(false) }

    if (registerSuccess) {
        navController.navigate("login")
        FirebaseAuth.getInstance().signOut()
        registerSetSuccess(false)
    }

    Button(
        onClick = {
            if (email.isNotEmpty() && passwd.isNotEmpty() && name.isNotEmpty() && callNum.isNotEmpty() && birthday.isNotEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    registerToFirebase(email, passwd, name, callNum, birthday, context) {
                        registerSetSuccess(true)
                    }
                }
            }
            else {
                Toast.makeText(context, "정보를 똑바로 입력해 주세요", Toast.LENGTH_SHORT).show()
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

@Composable
@Preview
fun takeImageButton() { // 갤러리 불러오는 메소드
    var imageUri = remember { mutableStateOf<Uri?>(null) } // UPDATE
    val context = LocalContext.current
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }

    val launcher = rememberLauncherForActivityResult(contract =
    ActivityResultContracts.GetContent()) { uri: Uri? ->
        imageUri.value = uri // UPDATE
    }

    Button(
        onClick = {
            launcher.launch("image/*")
        },
        modifier = Modifier.size(width = 80.dp, height = 40.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
    ) {
        Text("갤러리", color = Color.White, fontSize = 10.sp)
    }
}

@Composable
fun regisProductButton(
    navController: NavController,
    imageUri: Uri?,
    productName: String,
    price: String,
    time: String
) {
    val context = LocalContext.current
    val (upLoadSuccess, upLoadSetSuccess) = remember { mutableStateOf(false) }


    if (upLoadSuccess) {
        navController.navigate("userMain")
        upLoadSetSuccess(false)
    }

    Button(
        onClick = {
            if (productName.isNotEmpty() && price.isNotEmpty() && time.isNotEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    upLoadToFirebase(imageUri, productName, price, time, context) {
                        upLoadSetSuccess(true)
                    }
                }
            }
            else {
                Toast.makeText(context, "물품 정보를 똑바로 입력해 주세요", Toast.LENGTH_SHORT).show()
            }
        },
        modifier = Modifier.size(width = 80.dp, height = 40.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
    ) {
        Text("등록", color = Color.White, fontSize = 10.sp)
    }
}