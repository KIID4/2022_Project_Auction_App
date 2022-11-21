package com.example.auction.app.ui.shapes

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
@Preview
fun TopAppBar(navController : NavController) {
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
                            indication = null, // 버튼 중복 방지
                            enabled = true,
                            onClickLabel = null,
                            role = null,
                            onClick = {
                                navController.navigate("Login")
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
fun TopAppBarTest() {
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
                        indication = null, // 버튼 중복 방지
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

