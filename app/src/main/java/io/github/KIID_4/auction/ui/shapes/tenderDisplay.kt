package io.github.KIID_4.auction.ui.shapes

import android.graphics.Bitmap
import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import io.github.KIID_4.auction.ui.data.productInfo
import kotlinx.coroutines.CompletionHandler

@Composable
fun tenderDisplay(navController: NavController) {
    val (buyPrice, setBuyPrice) = remember { mutableStateOf(TextFieldValue()) }
    val (reBuyPrice, setReBuyPrice) = remember { mutableStateOf(TextFieldValue()) }
    val bitmap : Bitmap? = productInfo.btm
    val price: Int = productInfo.price
    val productName : String = productInfo.productName

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
                if (bitmap != null) {
                    Image(
                        bitmap = bitmap.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier.size(width = 200.dp, height = 200.dp)
                    )
                }
                else Spacer(Modifier.padding(100.dp))

            }

            Spacer(Modifier.padding(30.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("가격", fontSize = 17.sp)
                Spacer(Modifier.padding(22.dp))
                informationBar("가격을 입력해 해주세요", 150, 55, buyPrice, setBuyPrice)
            }

            Spacer(Modifier.padding(15.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("가격 확인", fontSize = 17.sp)
                Spacer(Modifier.padding(10.dp))
                informationBar("가격을 한번더 입력해주세요", 150, 55, reBuyPrice, setReBuyPrice)
            }

            Spacer(Modifier.padding(40.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                tenderButton(navController, price, buyPrice.text, reBuyPrice.text, productName)
            }
        }
    }
}
