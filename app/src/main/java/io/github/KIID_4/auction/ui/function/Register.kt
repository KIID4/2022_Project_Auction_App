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
    FirebaseAuth.getInstance() // 파이어베이스 회원가입 메소드
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

fun inputToFirebase(name: String, callNum: String, birthday: String, useruid: String) { // 회원가입시 파이어베이스에 사용자 정보 저장 메소드
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

fun updateToFirebase(name: String, callNum: String, birthday: String) { // 정보 수정시 파이어베이스내 정보 업데이트 메소드
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

fun loginToFirebase(email: String, passwd: String, context: Context, setSuccess: () -> Unit) { // 파이어베이스 로그인 메소드
    FirebaseAuth.getInstance()
        .signInWithEmailAndPassword(email, passwd)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = Firebase.auth.currentUser
                var useruid = ""
                if (user != null) {
                    useruid = user.uid
                    updateUserInfo(useruid)
                    setSuccess()
                    Toast.makeText(context, "로그인에 성공하셨습니다.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "로그인에 실패하셨습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
}


fun pushProductInfoToFirebase(bitmap: Bitmap, productName: String, price: String, time: String, context: Context, upLoadSetSuccess: () -> Unit) {
    val user = Firebase.auth.currentUser // 물품 정보 입력 후 저장 메소드
    val productInfoModel = HashMap<String, Any>()
    val stream = ByteArrayOutputStream()
    val str: String

    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream) // 받아온 비트맵(png)을 문자열로 변환하여 저장
    val byteArray = stream.toByteArray() // 받아온 비트맵(png)을 문자열로 변환하여 저장
    str = Base64.encodeToString(byteArray, Base64.DEFAULT) // 받아온 비트맵(png)을 문자열로 변환하여 저장

    productInfoModel["Bitmap"] = str
    productInfoModel["productName"] = productName
    productInfoModel["price"] = price
    productInfoModel["time"] = time
    var useruid = ""

    if (user != null) {
        useruid = user.uid
        productInfoModel["userid"] = useruid
        productInfoModel["seller"] = user.displayName.toString()
    }

    FirebaseDatabase.getInstance().reference
        .child("users")
        .child("Products")
        .child(productName)
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
    FirebaseAuth.getInstance().currentUser!! // 파이어베이스 회원 정보 수정 메소드
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

fun pushBulletinInfoToFirebase(title : String, content : String, context: Context, upLoadSetSuccess: () -> Unit) {
    val user = Firebase.auth.currentUser // 파이어베이스 공지사항 데이터 저장 메소드
    val bulletinInfoModel = HashMap<String, Any>()
    val hits = "0"

    bulletinInfoModel["title"] = title
    bulletinInfoModel["content"] = content
    bulletinInfoModel["hits"] = hits
    var useruid = ""

    if (user != null) {
        useruid = user.uid
        bulletinInfoModel["userid"] = useruid
        bulletinInfoModel["writer"] = user.displayName.toString()
    }

    FirebaseDatabase.getInstance().reference
        .child("users")
        .child("Bulletin")
        .push()
        .setValue(bulletinInfoModel)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                upLoadSetSuccess()
                Toast.makeText(context, "게시물을 성공적으로 업로드하였습니다", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "게시물이 정상적으로 업로드 되지 않았습니다.", Toast.LENGTH_SHORT).show()
            }
        }
}


fun pushNoticeToFirebase(title : String, content : String, context: Context, upLoadSetSuccess: () -> Unit) {
    val user = Firebase.auth.currentUser // 파이어베이스 게시글 정보 저장
    val bulletinInfoModel = HashMap<String, Any>()
    val hits = "0"

    bulletinInfoModel["title"] = title
    bulletinInfoModel["content"] = content
    bulletinInfoModel["hits"] = hits
    var useruid = ""

    if (user != null) {
        useruid = user.uid
        bulletinInfoModel["userid"] = useruid
    }

    FirebaseDatabase.getInstance().reference
        .child("users")
        .child("notice")
        .push()
        .setValue(bulletinInfoModel)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                upLoadSetSuccess()
                Toast.makeText(context, "공지사항이 성공적으로 업로드하였습니다", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "공지사항이 정상적으로 업로드 되지 않았습니다.", Toast.LENGTH_SHORT).show()
            }
        }
}