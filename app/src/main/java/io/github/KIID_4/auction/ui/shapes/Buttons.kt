package io.github.KIID_4.auction.ui.shapes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun MainButton() {
    Row(
        modifier = Modifier.padding(10.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        Button(onClick = { },
            modifier = Modifier.size(width = 100.dp, height = 100.dp).
            clip(CircleShape),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffAD55F2))
        ) {
            Text("온라인 경매", color = Color.White, fontSize = 17.sp, textAlign = TextAlign.Center)
        }

        Spacer(Modifier.weight(0.5f))

        Button(onClick = { },
            modifier = Modifier.size(width = 100.dp, height = 100.dp).
            clip(CircleShape),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffD1C0FF))
        ) {
            Text("물품 등록", color = Color.White, fontSize = 17.sp, textAlign = TextAlign.Center)
        }

        Spacer(Modifier.weight(0.5f))

        Button(onClick = { },
            modifier = Modifier.size(width = 100.dp, height = 100.dp).
            clip(CircleShape),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff888DFF))
        ) {
            Text("게시판", color = Color.White, fontSize = 17.sp, textAlign = TextAlign.Center)
        }
    }
}

@Composable
@Preview
fun DuplicationButton(){
    Button(onClick = { },
        modifier = Modifier.size(width = 80.dp, height = 30.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
    ) {
        Text("중복 확인", color = Color.White, fontSize = 10.sp)
    }
}