package io.github.KIID_4.auction.ui.shapes

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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import io.github.KIID_4.auction.ui.function.takeBulletinFromFirebase

@Composable
fun bulletinBoardList(navController : NavController) {
    val scrollState = rememberLazyListState()
    val (boardList, setboard) = remember { mutableStateOf(listOf <Triple<String, String, Int>>()) }
    // 게시글 제목, 작성자, 조회수가 저장된 리스트

    takeBulletinFromFirebase(setboard)  // 파이어베이스에서 게시글 가져오기

    LazyColumn(
        state = scrollState) {
        items(boardList.size) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                val (title, writter, hits) = boardList[it]
                Button(
                    onClick = {
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ) {
                    Column {
                        Text("게시글 제목 : $title      작성자 : $writter      조회수 : $hits ", fontSize = 17.sp)
                    }
                }
            }
        }
    }
    bulletinWriteButton(navController)
}