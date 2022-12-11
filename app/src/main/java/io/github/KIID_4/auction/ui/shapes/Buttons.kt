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
import io.github.KIID_4.auction.ui.function.*
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
        Button(onClick = {
            navController.navigate("auction")
        },
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

        Button(onClick = {
            navController.navigate("bulletin")
        },
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
                navController.navigate("modifyingInfo")
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
fun modifiyButton(passWD: String, repassWD: String, name: String, callNumber: String, birthday : String, navController : NavController) {
    val context = LocalContext.current
    val (changeSuccess, setSuccess) = remember { mutableStateOf(false) }

    if (changeSuccess) {
        navController.navigate("userMain")
        setSuccess(false)
    }

    Button(
        onClick = {
            if ((passWD == repassWD) && passWD.isNotEmpty() && name.isNotEmpty() && callNumber.isNotEmpty() && birthday.isNotEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    modifyToFirebase(passWD, name, callNumber, birthday, context) {
                        setSuccess(true)
                    }
                }
            }
            else Toast.makeText(context, "변경할 정보를 똑바로 입력해주십시오", Toast.LENGTH_SHORT).show()
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
    val imageUri = remember { mutableStateOf<Uri?>(null) } // UPDATE

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
    bitmap: Bitmap?,
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
            if (bitmap != null && productName.isNotEmpty() && price.isNotEmpty() && time.isNotEmpty() && isInteger(price) && isInteger(time)) {
                CoroutineScope(Dispatchers.IO).launch {
                    pushProductInfoToFirebase(bitmap, productName, price, time, context) {
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
@Composable
fun registerBulletButton(navController: NavController, title: String, content: String) {
    val context = LocalContext.current

    val (upLoadSuccess, upLoadSetSuccess) = remember { mutableStateOf(false) }


    if (upLoadSuccess) {
        navController.navigate("userMain")
        upLoadSetSuccess(false)
    }

    Button(
        onClick = {
            if (title.isNotEmpty() && content.isNotEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    pushBulletinInfoToFirebase(title, content, context) {
                        upLoadSetSuccess(true)
                    }
                }
            }
            else {
                Toast.makeText(context, "게시물을 한번더 확인해 주세요", Toast.LENGTH_SHORT).show()
            }
        },
        modifier = Modifier.size(width = 80.dp, height = 40.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
    ) {
        Text("등록", color = Color.White, fontSize = 10.sp)
    }
}

@Composable
fun writeButton(navController: NavController, info : String) { // 게시글 작성 버튼
    val context = LocalContext.current
    val user = Firebase.auth.currentUser

    Spacer(Modifier.padding(10.dp))
    Row {
        Button(
            onClick = {
                if(info == "notice") {
                    if (info.isNotEmpty()) {
                        if (user != null) {
                            val userUid = user.uid
                            if (userUid == "23ueQFFFUDeDxWTFKGcV9NYOxGR2") {
                                navController.navigate("NoticeLayout")
                            }
                            else Toast.makeText(context, "권한이 존재하지 않습니다.", Toast.LENGTH_SHORT).show()
                        }
                        else Toast.makeText(context, "로그인이 필요합니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                else navController.navigate("bulletinLayout")
            },
            modifier = Modifier.size(width = 80.dp, height = 40.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
        ) {
            Text("작성하기", color = Color.White, fontSize = 12.sp)
        }
    }
}


@Composable
fun registerNoticeButton(navController: NavController, title: String, content: String) {
    val context = LocalContext.current

    val (upLoadSuccess, upLoadSetSuccess) = remember { mutableStateOf(false) }

    if (upLoadSuccess) {
        navController.navigate("userMain")
        upLoadSetSuccess(false)
    }

    Button(
        onClick = {
            if (title.isNotEmpty() && content.isNotEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    pushNoticeToFirebase(title, content, context) {
                        upLoadSetSuccess(true)
                    }
                }
            }
            else {
                Toast.makeText(context, "공자사항글을 한번더 확인해 주세요", Toast.LENGTH_SHORT).show()
            }
        },
        modifier = Modifier.size(width = 80.dp, height = 40.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
    ) {
        Text("등록", color = Color.White, fontSize = 10.sp)
    }
}

@Composable
fun tenderButton(navController: NavController, price: Int, buyPrice: String, reBuyPrice: String, productName: String) {
    val context = LocalContext.current
    val (priceSuccess, setPriceSuccess) = remember { mutableStateOf(false) }

    if(priceSuccess) {
        navController.navigate("auction")
        setPriceSuccess(false)
    }

    Button(
        onClick = {
            if (buyPrice.isNotEmpty() && reBuyPrice.isNotEmpty() && isInteger(buyPrice) && isInteger(reBuyPrice) && (buyPrice == reBuyPrice)) {
                if(price < buyPrice.toInt()) {
                    updateTenderPrice(buyPrice, productName, context) {
                        setPriceSuccess(true)
                    }
                }
                else Toast.makeText(context, "현재 입찰하신 가격보다 현재입찰가보다 적습니다.", Toast.LENGTH_SHORT).show()
            }
            else Toast.makeText(context, "가격을 한번더 확인해 주세요.", Toast.LENGTH_SHORT).show()
        },
        modifier = Modifier.size(width = 80.dp, height = 40.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
    ) {
        Text("입찰", color = Color.White, fontSize = 15.sp)
    }
}
