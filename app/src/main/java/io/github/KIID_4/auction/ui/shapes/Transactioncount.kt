package io.github.KIID_4.auction.ui.shapes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun transsactionCount() { // 거래내역 개수 컴포넌트
    val buyCount = 0
    val sellCount = 0

    Row(
        modifier = Modifier.padding(25.dp),
    ) {
        Surface(
            modifier = Modifier.size(width = 110.dp, height = 100.dp),
            color = Color(0xff888DFF),
            shape = RoundedCornerShape((10.dp)),
        ) {
            Row(
                horizontalArrangement = Arrangement.Center, // 가로
                verticalAlignment = Alignment.CenterVertically // 세로
            ) {
                Text("거래내역", fontSize = 18.sp, color = Color.White)
            }
        }

        Spacer(Modifier.padding(2.dp))

        Column{
            Row{
                Surface(
                    modifier = Modifier.size(width = 95.dp, height = 45.dp),
                    color = Color.White,
                    shape = RoundedCornerShape((10.dp)),
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center, // 가로
                        verticalAlignment = Alignment.CenterVertically // 세로
                    ) {
                        Text("구매 개수", fontSize = 14.sp)
                    }
                }

                Spacer(Modifier.padding(2.dp))

                Surface(
                    modifier = Modifier.size(width = 95.dp, height = 45.dp),
                    color = Color.White,
                    shape = RoundedCornerShape((10.dp)),
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center, // 가로
                        verticalAlignment = Alignment.CenterVertically // 세로
                    ) {
                        Text("판매 개수", fontSize = 14.sp)
                    }
                }
            }

            //------------------------------------------------------------
            Spacer(Modifier.padding(3.dp))
            Row{
                Surface(
                    modifier = Modifier.size(width = 95.dp, height = 50.dp),
                    color = Color.White,
                    shape = RoundedCornerShape((10.dp)),
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center, // 가로
                        verticalAlignment = Alignment.CenterVertically // 세로
                    ) {
                        Text("$buyCount", fontSize = 14.sp)
                    }
                }

                Spacer(Modifier.padding(2.dp))

                Surface(
                    modifier = Modifier.size(width = 95.dp, height = 50.dp),
                    color = Color.White,
                    shape = RoundedCornerShape((10.dp)),
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center, // 가로
                        verticalAlignment = Alignment.CenterVertically // 세로
                    ) {
                        Text("$sellCount", fontSize = 14.sp)
                    }
                }
            }
        }
    }
}