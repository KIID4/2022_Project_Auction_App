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
import io.github.KIID_4.auction.ui.function.saveDataNotice
import io.github.KIID_4.auction.ui.function.takeNoticeInFromFirebase

@Composable
fun noticeList(navController: NavController) {
    val scrollState = rememberLazyListState()
    val (noticeList, setBoard) = remember { mutableStateOf(listOf <Triple<String, Int, String>>()) }
    // 게시글 제목, 작성자, 조회수가 저장된 리스트

    takeNoticeInFromFirebase(setBoard)  // 파이어베이스에서 게시글 가져오기

    LazyColumn(
        state = scrollState,
        modifier = Modifier.fillMaxHeight(0.8f)) {
        items(noticeList.size) {
            Column{
                Spacer(Modifier.padding(10.dp))
            }
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                val (title, hits, content) = noticeList[it]
                Button(
                    onClick = {
                        saveDataNotice(title, hits, content)
                        navController.navigate("noticeInfo")
                    },
                    modifier = Modifier.fillMaxWidth().height(80.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffF9F1F1)),
                ) {
                    Text("게시글 제목 : $title                            조회수 : $hits ", fontSize = 17.sp)
                }
            }
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End  // 수평,
    ) {
        writeButton(navController, "notice")
        Spacer(Modifier.padding(10.dp))
    }
}