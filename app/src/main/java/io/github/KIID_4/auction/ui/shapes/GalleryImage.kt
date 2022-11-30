package io.github.KIID_4.auction.ui.shapes

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun galleryImage() {

    val (productName, setproductName) = remember { mutableStateOf(TextFieldValue()) }
    val (price, setPrice) = remember { mutableStateOf(TextFieldValue()) }
    val (time, setTime) = remember { mutableStateOf(TextFieldValue()) }

    Row (
        modifier = Modifier.padding(70.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        Column {
            Surface(
                modifier = Modifier.fillMaxWidth().border(width = 3.dp, color = Color.Black, shape = RectangleShape),
                shape = RoundedCornerShape(20.dp),
                color = Color.White
            ) {
                Spacer(Modifier.padding(100.dp))
            }

            Spacer(Modifier.padding(5.dp))

            Row {
                Spacer(Modifier.weight(1.0f))
                takeImageButton() // 파이어베이스 DB상에 등록
            }

            Spacer(Modifier.padding(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("물품 이름", fontSize = 17.sp)
                Spacer(Modifier.padding(10.dp))
                productInfo(productName, setproductName, 150)
            }

            Spacer(Modifier.padding(5.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("판매 시간", fontSize = 17.sp)
                Spacer(Modifier.padding(10.dp))
                productInfo(time, setTime, 90)
                Spacer(Modifier.padding(10.dp))
                Text("시간", fontSize = 17.sp)
            }

            Spacer(Modifier.padding(5.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("초기 가격", fontSize = 17.sp)
                Spacer(Modifier.padding(10.dp))
                productInfo(price, setPrice, 150)
            }

            Spacer(Modifier.padding(10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Spacer(Modifier.weight(1.0f))
                regisProductButton()
            }
        }
    }
}