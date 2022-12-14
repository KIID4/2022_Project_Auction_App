package io.github.KIID_4.auction.ui.shapes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.KIID_4.auction.ui.function.takeMyItemFromFirebase

@Composable
fun myAuctionList() { // 현재 나의 경매 리스트 컴포넌트
    val scrollState = rememberLazyListState()
    val (auctionMyItemList, setAuctionMyItemList) = remember { mutableStateOf(listOf <Triple<String, Int, Int>>()) }

    takeMyItemFromFirebase(setAuctionMyItemList)  // 파이어베이스에서 게시글 가져오기

    LazyColumn(
        state = scrollState,
        modifier = Modifier.fillMaxHeight(0.8f)) {
        items(auctionMyItemList.size) {
            Column{
                Spacer(Modifier.padding(10.dp))
            }
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                val (title, price, time) = auctionMyItemList[it]
                Box(
                    modifier = Modifier.fillMaxWidth().height(80.dp).background(color =  Color(0xffF9F1F1))
                ) {
                    Text("물품 이름  : $title \n 현재 가격 : $price \n 남은 시간 : $time", fontSize = 17.sp)
                }
            }
        }
    }
}