package io.github.KIID_4.auction.ui.function

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

@Composable
fun updateInfo(useruid: String) {
    val user = Firebase.auth.currentUser
    val context = LocalContext.current
    var name = ""
    val database : DatabaseReference = Firebase.database.reference



    val profileUpdates = userProfileChangeRequest {
        if(name != "") {
            displayName = name
            Toast.makeText(context, "사용자 이름 변경 성공", Toast.LENGTH_SHORT).show()
        }
    }
    if (user != null) {
        user.updateProfile(profileUpdates)
        Toast.makeText(context, "프로필 업데이트 성공", Toast.LENGTH_SHORT).show()

    }
}