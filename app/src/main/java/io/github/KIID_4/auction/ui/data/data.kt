package io.github.KIID_4.auction.ui.data

import android.graphics.Bitmap

object productInfo {
    var productName : String = ""
    var btm : Bitmap? = null
    var price : Int = 0
    var sellerName : String = ""
    var time : Int = 0
    var productUserUid : String = ""
    var buyerUid : String = ""
}

object bulletinInfo {
    var title : String = ""
    var writer : String = ""
    var hits : Int = 0
    var content : String = ""
}

object noticeInfo {
    var title : String = ""
    var hits : Int = 0
    var content : String = ""
}