package io.github.KIID_4.auction.ui.shapes

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.KIID_4.auction.ui.function.takeProductFromFirebase

@Composable
fun auctionList() {
    val scrollState = rememberLazyListState()
    val (bpnpList, setInfo) = remember { mutableStateOf(listOf <Triple<String, Bitmap, Int>>()) }
    // 비트맵, 물건 이름, 가격 정보 들어 있는 리스트
    val (sntList, setInfo2) = remember { mutableStateOf(listOf <Pair<String, Int>>()) }
    // 판매자 이름, 남은 시간
    takeProductFromFirebase(setInfo, setInfo2)  // 파이어베이스에서 사진 가져오기

    LazyColumn(
        state = scrollState) {
        items(bpnpList.size) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                val (productName, btm, price) = bpnpList[it]
                val (sellerName, time) = sntList[it]
                Button(
                    onClick = { },
                    modifier = Modifier.size(200.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ) {
                    Image(
                        bitmap = btm.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }


                Spacer(Modifier.weight(0.5f))
                Column {
                    Text("이름 : $productName       가격 : $price 원", fontSize = 15.sp)
                    Spacer(Modifier.padding(1.dp))
                    Text("판매자 : $sellerName       시간 : $time", fontSize = 15.sp)
                }
            }
        }
    }
}