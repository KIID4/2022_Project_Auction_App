package io.github.KIID_4.auction.ui.shapes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
    }
}

@Composable
@Preview
// Compose의 경우 Textfield에 Text의 상태를 저장하는 공간이 없음 즉 저장하는 부분을 만들어 줘야함
fun IDBar() {
    var searchInput by remember { mutableStateOf(TextFieldValue()) }

    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),  // width value will be ignored because of fillMaxWidth
            value = searchInput,
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
            onValueChange = { newValue -> searchInput = newValue },  // 사용자의 새로운 입력을 사용자의 입력을 넣어줌
            placeholder = { Text(text = "아이디", color = Color.Gray) }  // 바탕 글
        )
    }
}


@Composable
@Preview
// Compose의 경우 Textfield에 Text의 상태를 저장하는 공간이 없음 즉 저장하는 부분을 만들어 줘야함
fun PasswordBar() {
    var searchInput by remember { mutableStateOf(TextFieldValue()) }

    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),  // width value will be ignored because of fillMaxWidth
            value = searchInput,
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
            onValueChange = { newValue -> searchInput = newValue },  // 사용자의 새로운 입력을 사용자의 입력을 넣어줌
            placeholder = { Text(text = "비밀번호", color = Color.Gray) }  // 바탕 글
        )
    }
}

@Composable
// Compose의 경우 Textfield에 Text의 상태를 저장하는 공간이 없음 즉 저장하는 부분을 만들어 줘야함
fun InformationBar(value : String) {
    var searchInput by remember { mutableStateOf(TextFieldValue()) }

    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = Modifier.size(width = 200.dp, height = 45.dp),
            shape = RoundedCornerShape((10.dp)),
            value = searchInput,
            singleLine = true,  // 한줄로만 입력

            colors = @OptIn(ExperimentalMaterialApi::class) (ExposedDropdownMenuDefaults.textFieldColors(
                backgroundColor = Color(
                    0xFFE0E0E0
                )
            )),
            onValueChange = { newValue -> searchInput = newValue },  // 사용자의 새로운 입력을 사용자의 입력을 넣어줌
            placeholder = { Text(text = value, color = Color.Gray, fontSize = 10.sp) }  // 바탕 글
        )
    }
}
