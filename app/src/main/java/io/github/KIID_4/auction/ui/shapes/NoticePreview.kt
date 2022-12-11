package io.github.KIID_4.auction.ui.shapes

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import io.github.KIID_4.auction.ui.function.takeNoticeContentFromFirebase


@Composable
fun noticePreview(navController: NavController) {
    val (content, setContent) = remember { mutableStateOf("") }
    takeNoticeContentFromFirebase(setContent)
    Row(
        Modifier.padding(10.dp),
        horizontalArrangement = Arrangement.Center
        ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            color = Color(0xff44AFFC)
        ) {
            Column(Modifier.padding(10.dp)) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "공지사항", color = Color.White, fontSize = 22.sp)
                    Spacer(Modifier.weight(1.0f))
                    Text(text = "더보기", color = Color.White, fontSize = 16.sp, modifier = Modifier
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = LocalIndication.current, // 버튼 중복 방지
                            enabled = true,
                            onClickLabel = null,
                            role = null,
                            onClick = {
                                navController.navigate("notice")
                            }
                        )
                    )
                }

                Spacer(Modifier.padding(12.dp))
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    color = Color.White
                ) {
                    Column(Modifier.padding(10.dp)
                    ) {
                        Text(content, fontSize = 14.sp)

                        Spacer(Modifier.padding(40.dp)) // 밑 인덱스 맞춰주기 위함
                    }
                }
            }
        }
    }
}




