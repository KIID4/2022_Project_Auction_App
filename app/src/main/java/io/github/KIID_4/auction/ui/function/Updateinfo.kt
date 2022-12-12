package io.github.KIID_4.auction.ui.function

import android.content.Context
import android.graphics.Bitmap
import android.widget.Toast
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
import io.github.KIID_4.auction.ui.data.searchInfo

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

fun saveDataProductInfo(productName: String, btm: Bitmap, price: Int, sellerName: String, time: Int, userUid: String, buyerUid : String) {
    productInfo.productName = productName
    productInfo.btm = btm
    productInfo.price = price
    productInfo.sellerName = sellerName
    productInfo.time = time
    productInfo.productUserUid = userUid
    productInfo.buyerUid = buyerUid
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

fun saveSearchWord(search: String) {
    searchInfo.word = search
}


fun updateTenderPrice(
    buyPrice: String,
    productName: String,
    context: Context,
    currentUserMoney: Int,
    beforeUserMoney: Int,
    price: Int,
    buyerUserUid: String,
    setPriceSuccess: () -> Unit
) {
    val user = Firebase.auth.currentUser
    var currentUserUid = ""
    if (user != null) {
        currentUserUid = user.uid
    }


    val currentChange = currentUserMoney - buyPrice.toInt()
    val beforeChange = beforeUserMoney + price

    FirebaseDatabase.getInstance().reference // 현재 구매자 돈 업데이트
        .child("users")
        .child("info")
        .child(currentUserUid)
        .child("money")
        .setValue(currentChange.toString())
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {

                FirebaseDatabase.getInstance().reference // 물품 가격 업데이트
                    .child("users")
                    .child("Products")
                    .child(productName)
                    .child("price")
                    .setValue(buyPrice)
                    .addOnCompleteListener { task2 ->
                        if (task2.isSuccessful) {

                            FirebaseDatabase.getInstance().reference // 전 구매자 돈 업데이트
                                .child("users")
                                .child("info")
                                .child(buyerUserUid)
                                .child("money")
                                .setValue(beforeChange.toString())
                                .addOnCompleteListener { task3 ->
                                    if (task3.isSuccessful) {
                                        FirebaseDatabase.getInstance().reference // 현재 구매자 Uid 업데이트
                                            .child("users")
                                            .child("Products")
                                            .child(productName)
                                            .child("buyer")
                                            .setValue(currentUserUid)
                                            .addOnCompleteListener { task4 ->
                                                if (task4.isSuccessful) {
                                                    setPriceSuccess()
                                                    Toast.makeText(context, "입찰에 성공하셨습니다.", Toast.LENGTH_SHORT).show()
                                                } else Toast.makeText(context, "입찰에 실패하셨습니다.", Toast.LENGTH_SHORT)
                                                    .show()
                                            }
                                    }
                                }
                        }
                    }
            }
        }
}