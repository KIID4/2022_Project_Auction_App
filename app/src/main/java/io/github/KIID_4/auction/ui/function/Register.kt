package io.github.KIID_4.auction.ui.function

import android.content.Context
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


fun registerToFirebase(email: String, passwd: String, context: Context, registersetSuccess: () -> Unit) {
    FirebaseAuth.getInstance()
        .createUserWithEmailAndPassword(email, passwd)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                registersetSuccess()
                Toast.makeText(context, "회원가입에 성공하셨습니다.", Toast.LENGTH_SHORT).show()
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

fun modifyToFirebase(passwd: String, context: Context, setSuccess: () -> Unit) {
    FirebaseAuth.getInstance()

}
