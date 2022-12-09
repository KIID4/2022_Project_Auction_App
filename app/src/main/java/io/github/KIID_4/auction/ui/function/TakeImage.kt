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
fun takeImageToFirebase(
    setBitmap: (List<Bitmap?>) -> Unit,
    setPrice: (List<Int?>) -> Unit,
    setName: (List<String?>) -> Unit
) {
    val database = Firebase.database
    val myRef = database.getReference("users").child("Products")
    var bitmapImage by remember { mutableStateOf<Bitmap?>(null) }
    val priceList = mutableListOf<Int?>()
    val productName = mutableListOf<String?>()
    val bitmapList = mutableListOf<Bitmap?>()
    var key = ""
    var count = 0

    myRef.addListenerForSingleValueEvent(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            if (snapshot.exists()) {
                for (data in snapshot.children) {
                    if (count == 4) break
                    key = data.key as String
                    val title =  snapshot.child(key).child("Bitmap").value as String
                    val price =  (snapshot.child(key).child("price").value as String).toInt()
                    val name =  snapshot.child(key).child("productName").value as String
                    val encodeByte = Base64.decode(title, Base64.DEFAULT)
                    bitmapImage = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size)
                    bitmapList.add(bitmapImage)
                    priceList.add(price)
                    productName.add(name)
                    count++
                }
                setBitmap(bitmapList)
                setPrice(priceList)
                setName(productName)
            }
        }
        override fun onCancelled(error: DatabaseError) {
            // Failed to read value
            Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
        }
    } )

}