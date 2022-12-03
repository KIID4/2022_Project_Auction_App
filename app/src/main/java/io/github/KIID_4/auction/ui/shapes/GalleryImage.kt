package io.github.KIID_4.auction.ui.shapes

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun galleryImage(navController: NavController) {

    val (productName, setProductName) = remember { mutableStateOf(TextFieldValue()) }
    val (price, setPrice) = remember { mutableStateOf(TextFieldValue()) }
    val (time, setTime) = remember { mutableStateOf(TextFieldValue()) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current
    val bitmap =  remember { mutableStateOf<Bitmap?>(null) }

    val launcher = rememberLauncherForActivityResult(contract = // 갤러리에서 가져오는 이미지는 Uri형식으로 가져옴
    ActivityResultContracts.GetContent()) { uri: Uri? ->
            imageUri = uri
    }

    imageUri?.let { //
        if (Build.VERSION.SDK_INT < 28) {
            bitmap.value = MediaStore.Images
                .Media.getBitmap(context.contentResolver, it)

        } else {
            val source = ImageDecoder
                .createSource(context.contentResolver, it)
            bitmap.value = ImageDecoder.decodeBitmap(source)
        }
    }

    Row (
        modifier = Modifier.padding(70.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        Column {
            Surface(
                modifier = Modifier.fillMaxWidth().border(width = 3.dp, color = Color.Black, shape = RectangleShape),
                shape = RoundedCornerShape(20.dp),
                color = Color.White
            ) {
                if (bitmap.value != null) {
                    bitmap.value?.let { btm ->
                        Image(
                            bitmap = btm.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier.size(width = 200.dp, height = 200.dp)
                        )
                    }
                }
                else Spacer(Modifier.padding(100.dp))

            }

            Spacer(Modifier.padding(5.dp))

            Row {
                Spacer(Modifier.weight(1.0f))
                Button(
                    onClick = {
                        launcher.launch("image/*") // 갤러리 실행시켜주는 메소드
                    },
                    modifier = Modifier.size(width = 80.dp, height = 40.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                ) {
                    Text("갤러리", color = Color.White, fontSize = 10.sp)
                }
            }

            Spacer(Modifier.padding(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("물품 이름", fontSize = 17.sp)
                Spacer(Modifier.padding(10.dp))
                productInfo(productName, setProductName, 150)
            }

            Spacer(Modifier.padding(5.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("판매 시간", fontSize = 17.sp)
                Spacer(Modifier.padding(10.dp))
                productInfo(time, setTime, 90)
                Spacer(Modifier.padding(10.dp))
                Text("시간", fontSize = 17.sp)
            }

            Spacer(Modifier.padding(5.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("초기 가격", fontSize = 17.sp)
                Spacer(Modifier.padding(10.dp))
                productInfo(price, setPrice, 150)
            }

            Spacer(Modifier.padding(10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Spacer(Modifier.weight(1.0f))
                regisProductButton(navController, bitmap.value, productName.text, price.text, time.text)
            }
        }
    }
}

