package com.example.auction.app.ui.shapes

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ExposedDropdownMenuDefaults.textFieldColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.auction.app.ui.layout.*


@Composable
@Preview
fun TopAppBar() {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color(0xff4E7FFF)
    )  {
        Column(Modifier.padding(10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically  // Text 위젯들 간 세로 중앙 정렬 위함
            ) {
                Text(text = "안동균님", color = Color.White, fontSize = 18.sp)
                Spacer(Modifier.weight(1.0f))
                Text(text = "My", color = Color.White, fontSize = 20.sp, modifier = Modifier
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = LocalIndication.current, // 버튼 중복 방지
                            enabled = true,
                            onClickLabel = null,
                            role = null,
                            onClick = {

                            }
                        )
                )
            }
            Spacer(Modifier.padding(6.dp))
            SearchBar()
        }
    }
}

@Composable
@Preview
// Compose의 경우 Textfield에 Text의 상태를 저장하는 공간이 없음 즉 저장하는 부분을 만들어 줘야함
fun SearchBar() {
    var searchInput by remember { mutableStateOf(TextFieldValue()) }

    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .size(width = 0.dp, height = 52.dp),  // width value will be ignored because of fillMaxWidth
            value = searchInput,
            singleLine = true,  // 한줄로만 입력
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search, contentDescription = null, modifier = Modifier.background(
                        Color.LightGray
                    )
                )
            },
            colors = @OptIn(ExperimentalMaterialApi::class) textFieldColors(backgroundColor = Color(0xFFE0E0E0)),
            onValueChange = { newValue -> searchInput = newValue },  // 사용자의 새로운 입력을 사용자의 입력을 넣어줌
            placeholder = { Text(text = "물품검색", color = Color.Gray) }  // 바탕 글
        )
    }
}