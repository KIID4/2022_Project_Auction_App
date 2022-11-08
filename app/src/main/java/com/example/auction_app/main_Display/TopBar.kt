package com.example.au

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopAppBar(){
    Surface(
        modifier = Modifier.fillMaxWidth().height(115.dp),
        color = Color(0xffEFCECE)
    )  {
        Column(Modifier.padding(10.dp)){
            Row{
                Text(text = "안동균님", color = Color.Black, fontSize = 18.sp)
                Spacer(Modifier.weight(1.0f))
                TextButton(onClick = {},
                    modifier = Modifier.size(width = 30.dp, height = 24.dp),
                    contentPadding = PaddingValues(0.dp) // 기존의 버튼과 Padding 기본값이 다름
                ) {
                    Text(text = "My", color = Color.Black, fontSize = 20.sp)
                }
            }
            Spacer(Modifier.padding(10.dp))
            SearchBar()
        }
    }
}

@Composable
// Compose의 경우 Textfield에 Text의 상태를 저장하는 공간이 없음 즉 저장하는 부분을 만들어 줘야함
fun SearchBar() {
    var searchInput by remember { mutableStateOf(TextFieldValue()) }

    Row {
        Spacer(Modifier.width(30.dp))
        TextField(
            modifier = Modifier.background(Color.White).size(width = 350.dp, height = 52.dp),
            value = searchInput,
            singleLine = true, // 한줄로만 입력
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search, contentDescription = null, modifier = Modifier.background(
                        Color.LightGray
                    )
                )
            },
            onValueChange = { newValue -> searchInput = newValue }, // 사용자의 새로운 입력을 사용자의 입력을 넣어줌
            placeholder = { Text(text = "물품검색", color = Color.Gray) } // 바탕 글
        )
    }
}