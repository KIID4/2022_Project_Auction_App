package io.github.KIID_4.auction.ui.shapes

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun writeBulletin(navController: NavController) { // 공지사항 작성 컴포넌트
    val (title, setTitle) = remember { mutableStateOf(TextFieldValue()) }
    val (content, setContent) = remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center, // 수평
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("제목", fontSize = 20.sp)
            Spacer(Modifier.padding(10.dp))
            informationBar("게시글 제목 입력", 300, 55, title, setTitle)
        }

        Spacer(Modifier.padding(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center, // 수평,
        ) {
            Text("내용", fontSize = 20.sp)
            Spacer(Modifier.padding(10.dp))
            informationBar("",300, 455, content, setContent)
        }

        Spacer(Modifier.padding(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End  // 수평,
        ) {
            registerBulletButton(navController, title.text, content.text)
        }
    }
}