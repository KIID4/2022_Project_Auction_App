package io.github.KIID_4.auction.ui.function

import android.content.Context
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


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

fun loginToFirebase(email: String, passwd: String, context: Context, setSuccess: () -> Unit) {
    FirebaseAuth.getInstance()
        .signInWithEmailAndPassword(email, passwd)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                setSuccess()
                Toast.makeText(context, "로그인에 성공하셨습니다.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, task.exception?.message, Toast.LENGTH_SHORT).show()
            }
        }
}

fun inputToFirebase(name: String, callNum: String, birthday: String, useruid: String) { // 사용자의 데이터를 넣어줌
    val userModel = HashMap<String, Any>()

    userModel["name"] = name
    userModel["callNumber"] = callNum
    userModel["birthday"] = birthday
    userModel["uid"] = useruid
    userModel["money"] = "100000"

    FirebaseDatabase.getInstance().reference.child("users").child(useruid).setValue(userModel) // getReference

}

fun modifyToFirebase(passwd: String, context: Context, setSuccess: () -> Unit) {
    FirebaseAuth.getInstance()

}
