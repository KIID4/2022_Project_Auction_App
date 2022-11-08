package com.example.auction_app

import androidx.compose.material.Button
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


@Composable
fun MiddleButtons() {
    Column{
        Row(Modifier.padding(start = 15.dp, top = 130.dp)) {
            Button(onClick = {},
                modifier = Modifier.size(width = 120.dp, height = 120.dp),
                shape = RoundedCornerShape(30.dp)
            ) {
                Text("온라인 경매", color = Color(0xff613838), fontSize = 22.sp)
            }

            Spacer(Modifier.padding(5.dp))

            Button(onClick = {},
                modifier = Modifier.size(width = 120.dp, height = 120.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffF198FF))
            ) {
                Text("물품 등록", color = Color(0xff613838), fontSize = 25.sp)
            }

            Spacer(Modifier.padding(5.dp))

            Button(onClick = {},
                modifier = Modifier.size(width = 120.dp, height = 120.dp),
                shape = RoundedCornerShape(30.dp)
            ) {
                Text("게시판", color = Color(0xff613838), fontSize = 25.sp)
            }
        }
        Button(onClick = {},
            modifier = Modifier.size(width = 390.dp, height = 80.dp).padding(start = 15.dp, top = 15.dp),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text("공지사항", color = Color(0xff613838), fontSize = 25.sp)
        }
    }
}


