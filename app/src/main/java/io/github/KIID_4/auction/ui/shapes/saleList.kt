package io.github.KIID_4.auction.ui.shapes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.KIID_4.auction.ui.function.takeCurrentUserInfoFromFirebase
import io.github.KIID_4.auction.ui.function.takeSellProductFromFirebase

@Composable
fun saleList() { // 현재 경매중인 물품 리스트 컴포넌트
    val (currentUserMoney, setCurrentUserMoney) = remember { mutableStateOf(0) }
    val scrollState = rememberLazyListState()
    val (bpnpList, setInfo) = remember { mutableStateOf(listOf <Triple<String, Int, Int>>()) }
    // 물건이름, 가격 정보, 남은 시간 들어 있는 리스트

    takeCurrentUserInfoFromFirebase(setCurrentUserMoney)
    takeSellProductFromFirebase(setInfo)

    Column{
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Spacer(Modifier.padding(20.dp))
            Text("현재 남은 돈 : $currentUserMoney 원", fontSize = 20.sp)
        }

        Spacer(Modifier.padding(20.dp))

        LazyColumn(
            state = scrollState,
            modifier = Modifier.fillMaxHeight(0.8f)) {
            items(bpnpList.size) {
                Column{
                    Spacer(Modifier.padding(10.dp))
                }
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    val (title, price, time) = bpnpList[it]
                    Box(
                        modifier = Modifier.fillMaxWidth().height(80.dp).background(color =  Color(0xffF9F1F1))
                    ) {
                        Text("물품 이름  : $title \n 현재 가격 : $price \n 남은 시간 : $time", fontSize = 17.sp)
                    }
                }
            }
        }
    }
}

