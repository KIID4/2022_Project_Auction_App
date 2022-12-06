package io.github.KIID_4.auction.ui.shapes

import android.content.ContentValues.TAG
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
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
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalPagerApi::class)
@Composable
@Preview
fun popularPreview() {
    val database = Firebase.database
    val latitude = ""
    val myRef = database.getReference("users").child("Products").child("Bitmap")
    var bitmapImage by remember { mutableStateOf<Bitmap?>(null) }


    myRef.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            if (snapshot.exists()) {
                val value = snapshot.value as String
                val encodeByte = Base64.decode(value, Base64.DEFAULT)
                bitmapImage = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size)
            }
        }
        override fun onCancelled(error: DatabaseError) {
            // Failed to read value
            Log.w(TAG, "Failed to read value.", error.toException())
        }
    } )

    Row(
        Modifier.padding(10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Column{
            Text("인기 있는 물품", fontSize = 20.sp)
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(40.dp),
                shape = RoundedCornerShape(20.dp),
                color = Color.White
            ) {
                HorizontalPager(modifier = Modifier.fillMaxWidth(), count = 1) { page -> // 화면 슬라이드
                    Row {
                        if (bitmapImage != null) {
                            bitmapImage?.let { btm ->
                                Image(
                                    bitmap = btm.asImageBitmap(),
                                    contentDescription = null,
                                    modifier = Modifier.size(width = 200.dp, height = 200.dp)
                                )
                            }
                        }
                        else Text(latitude)
                    }
                }
            }
        }
    }
}



