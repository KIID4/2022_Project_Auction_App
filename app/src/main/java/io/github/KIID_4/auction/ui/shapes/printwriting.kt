package io.github.KIID_4.auction.ui.shapes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.KIID_4.auction.ui.data.bulletinInfo
import io.github.KIID_4.auction.ui.data.noticeInfo

@Composable
fun printBulletinInfo() { // 공지사항 정보 컴포넌트
    val title: String = bulletinInfo.title
    val writer : String = bulletinInfo.writer
    val hits: Int = bulletinInfo.hits
    val content: String = bulletinInfo.content

    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center, // 수평,
        ) {
            Text("작성자 : $writer", fontSize = 20.sp)
            Spacer(Modifier.padding(10.dp))
            Text("조회수 : $hits", fontSize = 20.sp)
        }

        Spacer(Modifier.padding(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start, // 수평
        ) {
            Text("제목", fontSize = 20.sp)
            Spacer(Modifier.padding(10.dp))
            Box(
                modifier = Modifier.fillMaxWidth(0.9f).background(color = Color.LightGray)
            ) {
                Text(title, fontSize = 20.sp)
            }
        }

        Spacer(Modifier.padding(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start, // 수평,
        ) {
            Text("내용", fontSize = 20.sp)
            Spacer(Modifier.padding(10.dp))
            Box(
                modifier = Modifier.fillMaxWidth(0.9f).fillMaxHeight(0.7f).background(color = Color.LightGray)
            ) {
                Text(content, fontSize = 20.sp)
            }
        }
    }
}

@Composable
fun printNoticeInfo() {
    val title: String = noticeInfo.title
    val hits: Int = noticeInfo.hits
    val content: String = noticeInfo.content

    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center, // 수평,
        ) {
            Spacer(Modifier.padding(10.dp))
            Text("조회수 : $hits", fontSize = 20.sp)
        }

        Spacer(Modifier.padding(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start, // 수평
        ) {
            Text("제목", fontSize = 20.sp)
            Spacer(Modifier.padding(10.dp))
            Box(
                modifier = Modifier.fillMaxWidth(0.9f).background(color = Color.LightGray)
            ) {
                Text(title, fontSize = 20.sp)
            }
        }

        Spacer(Modifier.padding(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start, // 수평,
        ) {
            Text("내용", fontSize = 20.sp)
            Spacer(Modifier.padding(10.dp))
            Box(
                modifier = Modifier.fillMaxWidth(0.9f).fillMaxHeight(0.7f).background(color = Color.LightGray)
            ) {
                Text(content, fontSize = 20.sp)
            }
        }
    }
}