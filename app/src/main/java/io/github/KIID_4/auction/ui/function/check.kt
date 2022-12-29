package io.github.KIID_4.auction.ui.function

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

fun isInteger(str: String): Boolean { // 숫자 검사 메소드(예외처리 이용)
    return try {
        str.toInt()
        true
    } catch (e: NumberFormatException) {
        false
    }
}

fun toString(x : Int): Boolean { // 문자 검사 메소드(예외처리 이용)
    return try {
        x.toString()
        true
    } catch (e: NumberFormatException) {
        false
    }
}