package io.github.KIID_4.auction.ui.function

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

fun isInteger(str: String): Boolean {
    return try {
        str.toInt()
        true
    } catch (e: NumberFormatException) {
        false
    }
}

fun toString(x : Int): Boolean {
    return try {
        x.toString()
        true
    } catch (e: NumberFormatException) {
        false
    }
}

fun checkPermission(text: String, permissionCheck : () -> Unit) {
    val user = Firebase.auth.currentUser

    if (text == "notice") {
        if (user != null) {
            val userUid = user.uid
            if (userUid == "23ueQFFFUDeDxWTFKGcV9NYOxGR2") {
                permissionCheck()
            }
        }
    }
}