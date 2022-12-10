package io.github.KIID_4.auction.ui.shapes

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.firebase.database.*
import io.github.KIID_4.auction.ui.function.takeImageToFirebase

@OptIn(ExperimentalPagerApi::class)
@Composable
@Preview
fun popularPreview() {
    val (bitmapImageList, setBitmap) = remember { mutableStateOf(listOf <Triple<String, Bitmap, Int>>()) }

    takeImageToFirebase(setBitmap)  // 파이어베이스에서 사진 가져오기

    Row(
        Modifier.padding(10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Column{
            Text("인기 있는 물품", fontSize = 20.sp)
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(50.dp),
                shape = RoundedCornerShape(30.dp),
                color = Color.White
            ) {
                HorizontalPager(modifier = Modifier.fillMaxSize(), count = bitmapImageList.size) { page -> // 화면 슬라이드
                    Row (
                        horizontalArrangement = Arrangement.Center
                    ) {
                        val (name, btm, price) = bitmapImageList[page]
                        Image(
                            bitmap = btm.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(0.5f)
                        )
                        Spacer(Modifier.weight(0.5f))
                        Column {
                            Text(price.toString() + "원", fontSize = 30.sp)
                            Spacer(Modifier.padding(5.dp))
                            Text(name, fontSize = 30.sp)
                        }
                    }
                }
            }
        }
    }
}



