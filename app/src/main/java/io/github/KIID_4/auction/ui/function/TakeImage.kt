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
fun takeImageToFirebase(setProductList: (List<Triple<String, Bitmap, Int>>) -> Unit) {
    val database = Firebase.database
    val myRef = database.getReference("users").child("Products")
    var price = 0

    myRef.addListenerForSingleValueEvent(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            if (snapshot.exists()) {
                var key: String
                val productList = mutableListOf<Triple<String, Bitmap, Int>>()
                for (data in snapshot.children) {
                    if (productList.count() == 4) break
                    key = data.key as String
                    val title =  snapshot.child(key).child("Bitmap").value as String
                    val check = (snapshot.child(key).child("price").value as String)
                    if (check != "null") {
                         price =  check.toInt() // null check required
                    }
                    val name =  snapshot.child(key).child("productName").value as String
                    val encodeByte = Base64.decode(title, Base64.DEFAULT)
                    val bitmapImage = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size)
                    productList.add(Triple(name, bitmapImage, price))
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