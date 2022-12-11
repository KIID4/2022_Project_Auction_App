package io.github.KIID_4.auction.ui.shapes

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.KIID_4.auction.ui.function.takeUserInfoFromFirebase

@Composable
fun saleList() {
    val (money, setMoney) = remember { mutableStateOf(0) }

    takeUserInfoFromFirebase(setMoney)

    Column{
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Spacer(Modifier.padding(20.dp))
            Text("현재 남은 돈 : $money 원", fontSize = 20.sp)
        }
    }
}

