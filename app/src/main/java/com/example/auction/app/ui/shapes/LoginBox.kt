package com.example.auction.app.ui.shapes

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
@Preview
fun LoginBox(navController : NavController){
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically  // Text 위젯들 간 세로 중앙 정렬 위함
    )  {
        Column(Modifier.padding(20.dp)){
            IDBar()
            Spacer(Modifier.padding(1.dp))
            PasswordBar()
            Spacer(Modifier.padding(10.dp))
            Button(onClick = { },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff070000))
            ) {
                Text("로그인", color = Color.White, fontSize = 17.sp, textAlign = TextAlign.Center)
            }
        }
    }
}