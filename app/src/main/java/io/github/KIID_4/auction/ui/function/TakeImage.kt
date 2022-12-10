package io.github.KIID_4.auction.ui.function

import android.content.ContentValues
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
import androidx.compose.runtime.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

@Composable
fun take4ImageFromFirebase(setProductList: (List<Triple<String, Bitmap, Int>>) -> Unit) {
    val database = Firebase.database
    val myRef = database.getReference("users").child("Products").limitToFirst(4)
    var price = 0

    myRef.addListenerForSingleValueEvent(object : ValueEventListener { // 데이터 한번만 받고 연결 닫는 함수
        override fun onDataChange(snapshot: DataSnapshot) {
            if (snapshot.exists()) {
                var key: String
                val productList = mutableListOf<Triple<String, Bitmap, Int>>()
                for (data in snapshot.children) {
                    key = data.key as String
                    val title =  snapshot.child(key).child("Bitmap").value as String
                    val check = (snapshot.child(key).child("price").value as String)
                    if (check != "null") {
                        price =  check.toInt() // null check required
                    }
                    val productName =  snapshot.child(key).child("productName").value as String
                    val encodeByte = Base64.decode(title, Base64.DEFAULT)
                    val bitmapImage = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size)
                    productList.add(Triple(productName, bitmapImage, price))
                }
                if (productList.isNotEmpty()) {
                    setProductList(productList.toList())
                }
            }
        }
        override fun onCancelled(error: DatabaseError) {
            // Failed to read value
            Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
        }
    } )
}

fun takeProductFromFirebase(
    setProductList: (List<Triple<String, Bitmap, Int>>) -> Unit,
    setProductList2: (List<Pair<String, Int>>) -> Unit
) {
    val database = Firebase.database
    val myRef = database.getReference("users").child("Products")
    var price = 0
    var time = 0

    myRef.addListenerForSingleValueEvent(object : ValueEventListener { // 데이터 한번만 받고 연결 닫는 함수
        override fun onDataChange(snapshot: DataSnapshot) {
            if (snapshot.exists()) {
                var key: String
                val productList = mutableListOf<Triple<String, Bitmap, Int>>()
                val productList2 = mutableListOf<Pair<String, Int>>()
                for (data in snapshot.children) {
                    key = data.key as String
                    val bitmap =  snapshot.child(key).child("Bitmap").value as String // 비트맵
                    val encodeByte = Base64.decode(bitmap, Base64.DEFAULT)
                    val bitmapImage = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size)
                    val checkPrice = (snapshot.child(key).child("price").value as String) // 물품 가격
                    if (checkPrice != "null") {
                        price =  checkPrice.toInt() // null check required
                    }
                    val checkTime = (snapshot.child(key).child("time").value as String)
                    if (checkTime != "null") {
                        time =  checkTime.toInt() // null check required
                    }
                    val sellerName = (snapshot.child(key).child("seller").value as String) // 판매자 이름
                    val productName =  snapshot.child(key).child("productName").value as String // 물품 이름
                    productList.add(Triple(productName, bitmapImage, price))

                    productList2.add(Pair(sellerName, time))
                }
                if (productList.isNotEmpty() && productList2.isNotEmpty()) {
                    setProductList(productList.toList())
                    setProductList2(productList2.toList())
                }
            }
        }
        override fun onCancelled(error: DatabaseError) {
            // Failed to read value
            Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
        }
    } )
}