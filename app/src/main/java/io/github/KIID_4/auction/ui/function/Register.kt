package io.github.KIID_4.auction.ui.function

import android.content.Context
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


fun registerToFirebase(email: String, passwd: String, context: Context, setSuccess: () -> Unit) {
    FirebaseAuth.getInstance()
        .createUserWithEmailAndPassword(email, passwd)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                loginToFirebase(email, passwd, context, setSuccess)
            } else if (!task.exception?.message.isNullOrEmpty()) {
                Toast.makeText(context, task.exception?.message, Toast.LENGTH_SHORT).show()
            } else {
                loginToFirebase(email, passwd, context, setSuccess)
            }
        }
}

fun loginToFirebase(email: String, passwd: String, context: Context, setSuccess: () -> Unit) {
    FirebaseAuth.getInstance()
        .signInWithEmailAndPassword(email, passwd)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                setSuccess()
            } else {
                Toast.makeText(context, task.exception?.message, Toast.LENGTH_SHORT).show()
            }
        }
}

fun modifyToFirebase(passwd: String, context: Context, setSuccess: () -> Unit) {
    FirebaseAuth.getInstance()

}
