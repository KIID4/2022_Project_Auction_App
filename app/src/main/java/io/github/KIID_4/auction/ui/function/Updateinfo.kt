package io.github.KIID_4.auction.ui.function

import android.content.Context
import android.graphics.Bitmap
import android.widget.Toast
import androidx.navigation.NavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import io.github.KIID_4.auction.ui.data.bulletinInfo
import io.github.KIID_4.auction.ui.data.noticeInfo
import io.github.KIID_4.auction.ui.data.productInfo

fun updateUserInfo(useruid: String) {
    val user = Firebase.auth.currentUser
    var name = ""

    val database = Firebase.database
    val myRef = database.getReference("users").child("info").child(useruid).child("name")


    myRef.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            name = snapshot.value as String

            val profileUpdates = userProfileChangeRequest {
                displayName = name
            }

            if (user != null) {
                user.updateProfile(profileUpdates)
            }
        }

        override fun onCancelled(error: DatabaseError) {
        }
    } )
}

fun saveDataProductInfo(productName: String, btm: Bitmap, price: Int, sellerName: String, time: Int) {
    productInfo.productName = productName
    productInfo.btm = btm
    productInfo.price = price
    productInfo.sellerName = sellerName
    productInfo.time = time
}

fun saveDataBulletin(title: String, writer: String, hits: Int, content: String) {
    bulletinInfo.title = title
    bulletinInfo.writer = writer
    bulletinInfo.hits = hits
    bulletinInfo.content = content
}

fun saveDataNotice(title: String, hits: Int, content: String) {
    noticeInfo.title = title
    noticeInfo.hits = hits
    noticeInfo.content = content
}

fun updateTenderPrice(
    buyPrice: String,
    productName: String,
    context: Context,
    setPriceSuccess: () -> Unit
) {
    FirebaseDatabase.getInstance().reference
        .child("users")
        .child("Products")
        .child(productName)
        .child("price")
        .setValue(buyPrice)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                setPriceSuccess()
                Toast.makeText(context, "입찰을 성공적으로 업로드하였습니다", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "입찰이 정상적으로 되지 않았습니다.", Toast.LENGTH_SHORT).show()
            }
        }


}