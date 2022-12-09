package io.github.KIID_4.auction.ui.function

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