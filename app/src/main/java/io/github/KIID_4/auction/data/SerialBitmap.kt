package io.github.KIID_4.auction.data

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.ByteArrayOutputStream
import java.io.Serializable

class SerialBitmap(bitmap: Bitmap?) : Serializable {
    var bitmapData: ByteArray? = null
    init {
        if (bitmap != null) {
            try {
                val stream = ByteArrayOutputStream()
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
                stream.flush()
                stream.close()
                bitmapData = stream.toByteArray()
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }
    }
    val bitmap: Bitmap?
        get() = if (bitmapData == null) null else BitmapFactory.decodeByteArray(bitmapData, 0, bitmapData!!.size)
    companion object {
        private const val serialVersionUID = 7171158437011681222L
    }
}
