package io.github.KIID_4.auction.ui.shapes

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun writeBulletin(navController: NavController) {
    val (title, setTitle) = remember { mutableStateOf(TextFieldValue()) }
    val (content, setContent) = remember { mutableStateOf(TextFieldValue()) }

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center, // 수평
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("제목", fontSize = 20.sp)
            Spacer(Modifier.padding(10.dp))
            informationBar("게시글 제목 입력", title, setTitle)
        }

        Spacer(Modifier.padding(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.7f),
            horizontalArrangement = Arrangement.Center, // 수평
        ) {
            Spacer(Modifier.padding(30.dp))
            Text("내용", fontSize = 20.sp)
            Spacer(Modifier.padding(10.dp))
            bulletinBar("", content, setContent)
        }
        registerBulletinButton(navController, title.text, content.text)
    }
}


@Preview
@Composable
fun writeBulletin22() {
    val (title, setTitle) = remember { mutableStateOf(TextFieldValue()) }
    val (content, setContent) = remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.8f)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center, // 수평
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("제목", fontSize = 20.sp)
            Spacer(Modifier.padding(10.dp))
            informationBar("게시글 제목 입력", title, setTitle)
        }

        Spacer(Modifier.padding(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.7f),
            horizontalArrangement = Arrangement.Center, // 수평
        ) {
            Text("내용", fontSize = 20.sp)
            Spacer(Modifier.padding(10.dp))
            bulletinBar("", content, setContent)
        }

        //registerBulletinButton(navController, title.text, content.text)
    }
}