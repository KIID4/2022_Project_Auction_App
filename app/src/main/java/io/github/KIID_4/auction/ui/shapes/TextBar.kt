package io.github.KIID_4.auction.ui.shapes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
// Compose의 경우 Textfield에 Text의 상태를 저장하는 공간이 없음 즉 저장하는 부분을 만들어 줘야함
fun searchBar(navController: NavController) { // 검색란 컴포넌트
    var searchInput by remember { mutableStateOf(TextFieldValue()) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .wrapContentHeight(),  // width value will be ignored because of fillMaxWidth
            value = searchInput,
            singleLine = true,  // 한줄로만 입력
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search, contentDescription = null, modifier = Modifier.background(
                        Color.LightGray
                    )
                )
            },
            colors = @OptIn(ExperimentalMaterialApi::class) (ExposedDropdownMenuDefaults.textFieldColors(
        backgroundColor = Color(
            0xFFE0E0E0
        )
    )),
            onValueChange = { newValue -> searchInput = newValue },  // 사용자의 새로운 입력을 사용자의 입력을 넣어줌
            placeholder = { Text(text = "물품검색", color = Color.Gray) }  // 바탕 글
        )
        Spacer(Modifier.padding(10.dp))
        searchButton(navController, searchInput.text)
    }
}

@Composable
// Compose의 경우 Textfield에 Text의 상태를 저장하는 공간이 없음 즉 저장하는 부분을 만들어 줘야함
fun iDBar(searchInput: TextFieldValue, setter: (TextFieldValue) -> Unit) {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),  // width value will be ignored because of fillMaxWidth
            value = searchInput.text,
            singleLine = true,  // 한줄로만 입력
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person, contentDescription = null, modifier = Modifier.background(
                        Color.LightGray
                    )
                )
            },
            colors = @OptIn(ExperimentalMaterialApi::class) (ExposedDropdownMenuDefaults.textFieldColors(
                backgroundColor = Color(
                    0xFFE0E0E0
                )
            )),
            onValueChange = { setter(TextFieldValue(it)) },  // 사용자의 새로운 입력을 사용자의 입력을 넣어줌
            placeholder = { Text(text = "아이디", color = Color.Gray) }  // 바탕 글
        )
    }
}


@Composable
// Compose의 경우 Textfield에 Text의 상태를 저장하는 공간이 없음 즉 저장하는 부분을 만들어 줘야함
fun passwordBar(searchInput: TextFieldValue, setter: (TextFieldValue) -> Unit) {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),  // width value will be ignored because of fillMaxWidth
            value = searchInput.text,
            singleLine = true,  // 한줄로만 입력
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock, contentDescription = null, modifier = Modifier.background(
                        Color.LightGray
                    )
                )
            },
            colors = @OptIn(ExperimentalMaterialApi::class) (ExposedDropdownMenuDefaults.textFieldColors(
                backgroundColor = Color(
                    0xFFE0E0E0
                )
            )),
            onValueChange = { setter(TextFieldValue(it)) },  // 사용자의 새로운 입력을 사용자의 입력을 넣어줌
            placeholder = { Text(text = "비밀번호", color = Color.Gray) }  // 바탕 글
        )
    }
}

@Composable
// Compose의 경우 Textfield에 Text의 상태를 저장하는 공간이 없음 즉 저장하는 부분을 만들어 줘야함
fun informationBar(text: String, xValue : Int, yValue : Int, typing: TextFieldValue, setter: (TextFieldValue) -> Unit) {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = Modifier.size(width = xValue.dp, height = yValue.dp),
            shape = RoundedCornerShape((10.dp)),
            value = typing.text,
            singleLine = true,  // 한줄로만 입력

            colors = @OptIn(ExperimentalMaterialApi::class) (ExposedDropdownMenuDefaults.textFieldColors(
                backgroundColor = Color(
                    0xFFE0E0E0
                )
            )),
            onValueChange = { setter(TextFieldValue(it)) },  // 사용자의 새로운 입력을 사용자의 입력에 넣어줌
            placeholder = { Text(text = text, color = Color.Gray, fontSize = 10.sp) }  // 바탕 글
        )
    }
}