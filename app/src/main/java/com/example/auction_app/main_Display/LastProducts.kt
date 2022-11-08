package com.example.auction_app

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LastProducts() {
    val number  = remember {mutableStateOf(0)}

    Column(Modifier.padding(start = 45.dp, top = 350.dp)
    ) {
        Text("인기 있는 물품", color = Color(0xff613838), fontSize = 21.sp, fontWeight = FontWeight.SemiBold)

        Spacer(Modifier.padding(10.dp))

        Button(onClick = {},
            modifier = Modifier.size(width = 260.dp, height = 180.dp).padding(start = 50.dp),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffF198FF))
        ) {
            Text("물품 사진", color = Color(0xff613838), fontSize = 30.sp)
        }

        Button(onClick = {},
            modifier = Modifier.size(width = 260.dp, height = 120.dp).padding(start = 50.dp),
            shape = RoundedCornerShape(30.dp),
            enabled = false
        ) {
            Text("물품 정보", color = Color.White, fontSize = 30.sp)
        }

        Row(modifier = Modifier.padding(start = 50.dp, top = 10.dp)){
            Button(onClick = {
                number.value--;
                if(number.value < 0) number.value = 4
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),
                shape = CircleShape,
                modifier = Modifier.size(width = 40.dp, height = 40.dp)
            ) {
                Text(text = "◀", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 20.sp)
            }

            Spacer(Modifier.padding(27.dp))

            Text(text = "${number.value}", fontSize = 32.sp)

            Spacer(Modifier.padding(30.dp))

            Button(onClick = {
                number.value++;
                if(number.value > 4) number.value = 0
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),
                shape = CircleShape,
                modifier = Modifier.size(width = 40.dp, height = 40.dp)
            ) {
                Text(text = "▶", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 20.sp)
            }

        }
    }
}
