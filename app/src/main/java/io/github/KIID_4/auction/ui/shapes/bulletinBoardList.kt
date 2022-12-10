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
import androidx.compose.ui.unit.dp
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
        state = scrollState,
        modifier = Modifier.fillMaxHeight(0.8f)) {
        items(boardList.size) {
            Column{
                Spacer(Modifier.padding(10.dp))
            }
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                val (title, writer, hits) = boardList[it]
                Button(
                    onClick = {

                    },
                    modifier = Modifier.fillMaxWidth().height(80.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffF9F1F1)),
                ) {
                    Text("게시글 제목 : $title      작성자 : $writer      조회수 : $hits ", fontSize = 17.sp)
                }
            }
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End  // 수평,
    ) {
        writeButton(navController, "bulletin")
        Spacer(Modifier.padding(10.dp))
    }
}