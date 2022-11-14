package com.example.auction.app.ui.shapes

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.Button
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import io.github.untactorder.toasterAtSnackBar.InjectableSnackBar
import io.github.untactorder.toasterAtSnackBar.IosSimpleToast
import io.github.untactorder.toasterAtSnackBar.PastelColorSet
import io.github.untactorder.toasterAtSnackBar.PastelToast


@Composable
fun NoticePreview() {
    Surface(
        modifier = Modifier
            .size(width = 360.dp, height = 190.dp),
        shape = RoundedCornerShape(20.dp),
        color = Color(0xff44AFFC),
    ) {
        Row(
            modifier = Modifier.padding(7.dp)
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
                    onClick = {}
                )
            )
        }
    }
}


@Composable
fun buttons(){
    Column(
        modifier = Modifier.
            padding(vertical = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(40.dp)
        ) {
            Button(onClick = {},
                modifier = Modifier.size(width = 90.dp, height = 90.dp).
                clip(CircleShape),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffAD55F2))
            ) {
                Text("온라인 경매", color = Color.White, fontSize = 17.sp, textAlign = TextAlign.Center)
            }

            Spacer(Modifier.weight(0.5f))

            Button(onClick = {},
                modifier = Modifier.size(width = 90.dp, height = 90.dp).
                clip(CircleShape),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffD1C0FF))
            ) {
                Text("물품 등록", color = Color.White, fontSize = 17.sp, textAlign = TextAlign.Center)
            }

            Spacer(Modifier.weight(0.5f))

            Button(onClick = {},
                modifier = Modifier.size(width = 90.dp, height = 90.dp).
                clip(CircleShape),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff888DFF))
            ) {
                Text("게시판", color = Color.White, fontSize = 17.sp, textAlign = TextAlign.Center)
            }
        }
    }
}


