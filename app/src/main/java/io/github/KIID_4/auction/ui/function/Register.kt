package io.github.KIID_4.auction.ui.function

import android.content.Context
import android.graphics.Bitmap
import android.util.Base64
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import java.io.ByteArrayOutputStream


fun registerToFirebase(email: String, passwd: String, name: String, callNum: String, birthday: String, context: Context, registersetSuccess: () -> Unit) {
    FirebaseAuth.getInstance()
        .createUserWithEmailAndPassword(email, passwd)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                registersetSuccess()
                val user = Firebase.auth.currentUser
                var useruid = ""
                if (user != null) {
                    useruid = user.uid
                    inputToFirebase(name, callNum, birthday, useruid)
                    Toast.makeText(context, "회원가입에 성공하셨습니다.", Toast.LENGTH_SHORT).show()
                }
                else Toast.makeText(context, "회원가입에 실패하셨습니다.", Toast.LENGTH_SHORT).show()
            } else if (!task.exception?.message.isNullOrEmpty()) {
                Toast.makeText(context, task.exception?.message, Toast.LENGTH_SHORT).show()
            }
        }
}

fun inputToFirebase(name: String, callNum: String, birthday: String, useruid: String) {
    val userModel = HashMap<String, Any>()

    userModel["name"] = name
    userModel["callNumber"] = callNum
    userModel["birthday"] = birthday
    userModel["uid"] = useruid
    userModel["money"] = "100000"

    FirebaseDatabase.getInstance().reference
        .child("users")
        .child("info")
        .child(useruid)
        .setValue(userModel)
}

fun updateToFirebase(name: String, callNum: String, birthday: String) {
    val userModel = HashMap<String, Any>()
    val user = Firebase.auth.currentUser

    userModel["name"] = name
    userModel["callNumber"] = callNum
    userModel["birthday"] = birthday

    var useruid = ""
    if (user != null) {
        useruid = user.uid
        FirebaseDatabase.getInstance().reference
            .child("users")
            .child("info")
            .child(useruid)
            .setValue(userModel)
    }
}

fun loginToFirebase(email: String, passwd: String, context: Context, setSuccess: () -> Unit) {
    FirebaseAuth.getInstance()
        .signInWithEmailAndPassword(email, passwd)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = Firebase.auth.currentUser
                var useruid = ""
                if (user != null) {
                    useruid = user.uid
                    updateInfo(useruid)
                    setSuccess()
                    Toast.makeText(context, "로그인에 성공하셨습니다.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "로그인에 실패하셨습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
}


fun pushToFirebase(bitmap: Bitmap, productName: String, price: String, time: String, context: Context, upLoadSetSuccess: () -> Unit) {
    val user = Firebase.auth.currentUser
    val productInfoModel = HashMap<String, Any>()
    val stream = ByteArrayOutputStream()
    val str: String

    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
    val byteArray = stream.toByteArray()
    str = Base64.encodeToString(byteArray, Base64.DEFAULT)

    productInfoModel["Bitmap"] = str
    productInfoModel["productName"] = productName
    productInfoModel["price"] = price
    productInfoModel["time"] = time

    var useruid = ""
    if (user != null) {
        useruid = user.uid
        productInfoModel["userid"] = useruid
    }

    FirebaseDatabase.getInstance().reference
        .child("users")
        .child("Products")
        .setValue(productInfoModel)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                upLoadSetSuccess()
                Toast.makeText(context, "사진을 성공적으로 업로드하였습니다", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "사진이 정상적으로 업로드 되지 않았습니다.", Toast.LENGTH_SHORT).show()
            }
        }
}


fun modifyToFirebase(passwd: String,  name: String, callNumber: String, birthday : String, context: Context, setpasswordSuccess: () -> Unit) {
    FirebaseAuth.getInstance().currentUser!!
        .updatePassword (passwd)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                setpasswordSuccess()
                updateToFirebase(name, callNumber, birthday)
                Toast.makeText(context, "정보가 성공적으로 업데이트 되었습니다", Toast.LENGTH_SHORT).show()
            }
            else Toast.makeText(context, task.exception?.message, Toast.LENGTH_SHORT).show()
        }
}
