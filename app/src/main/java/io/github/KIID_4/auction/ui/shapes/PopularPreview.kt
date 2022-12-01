package io.github.KIID_4.auction.ui.shapes

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.firebase.database.*

@OptIn(ExperimentalPagerApi::class)
@Composable
@Preview
fun popularPreview() {
    val database : DatabaseReference = FirebaseDatabase.getInstance().reference
    var imagebitmap by remember { mutableStateOf<Bitmap?>(null) }


    Row(
        Modifier.padding(10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Column{
            Text("인기 있는 물품", fontSize = 20.sp)
            Surface(
                modifier = Modifier.fillMaxSize().padding(40.dp),
                shape = RoundedCornerShape(20.dp),
                color = Color.White
            ) {
                HorizontalPager(modifier = Modifier.fillMaxWidth(), count = 2) { page -> // 화면 슬라이드
                    Row {
                        if (imagebitmap != null) {
                            imagebitmap?.let { btm ->
                                Image(
                                    bitmap = btm.asImageBitmap(),
                                    contentDescription = null,
                                    modifier = Modifier.size(width = 200.dp, height = 200.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}



