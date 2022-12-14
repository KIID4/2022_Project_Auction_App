package io.github.KIID_4.auction.ui.function

import android.content.ContentValues
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
import androidx.compose.runtime.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import io.github.KIID_4.auction.ui.data.searchInfo

@Composable
fun take4ImageFromFirebase(setProductList: (List<Triple<String, Bitmap, Int>>) -> Unit) { // 파이어베이스에서 미리보기를 위해 제한된 경매물품의 정보를 가져옴
    val database = Firebase.database
    val myRef = database.getReference("users").child("Products").limitToFirst(4) // 4개까지 가져옴
    var price = 0

    myRef.addValueEventListener(object : ValueEventListener { // 데이터 한번만 받고 연결 닫는 함수
        override fun onDataChange(snapshot: DataSnapshot) {
            if (snapshot.exists()) {
                var key: String
                val productList = mutableListOf<Triple<String, Bitmap, Int>>()
                for (data in snapshot.children) {
                    key = data.key as String
                    val value =  snapshot.child(key).child("Bitmap").value as String
                    val check = (snapshot.child(key).child("price").value as String)
                    if (check != "null") {
                        price =  check.toInt()
                    }
                    val productName =  snapshot.child(key).child("productName").value as String
                    val encodeByte = Base64.decode(value, Base64.DEFAULT)
                    val bitmapImage = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size)
                    productList.add(Triple(productName, bitmapImage, price))
                }
                if (productList.isNotEmpty()) {
                    setProductList(productList.toList())
                }
            }
        }
        override fun onCancelled(error: DatabaseError) {
            // Failed to read value
            Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
        }
    } )
}

fun takeProductFromFirebase( // 파이어베이스에 있는 모든 경매 물품 목록 가져오는 함수
    setProductList: (List<Triple<String, Bitmap, Int>>) -> Unit,
    setProductList2: (List<Triple<String, Int, String>>) -> Unit,
    setBuyerUserUid: (String) -> Unit,
) {
    val database = Firebase.database
    val myRef = database.getReference("users").child("Products")
    var price = 0
    var time = 0

    myRef.addValueEventListener(object : ValueEventListener { // 데이터 상시수신대기 함수
        override fun onDataChange(snapshot: DataSnapshot) {
            if (snapshot.exists()) {
                var key: String
                val productList = mutableListOf<Triple<String, Bitmap, Int>>()
                val productList2 = mutableListOf<Triple<String, Int, String>>()
                for (data in snapshot.children) {
                    key = data.key as String
                    val bitmap =  snapshot.child(key).child("Bitmap").value as String // 비트맵
                    val encodeByte = Base64.decode(bitmap, Base64.DEFAULT)
                    val bitmapImage = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size)
                    val checkPrice = snapshot.child(key).child("price").value as String // 물품 가격
                    if (checkPrice != "null") {
                        price =  checkPrice.toInt() // null check required
                    }
                    val checkTime = snapshot.child(key).child("time").value as String
                    if (checkTime != "null") {
                        time =  checkTime.toInt() // null check required
                    }
                    val sellerName = snapshot.child(key).child("seller").value as String // 판매자 이름
                    val productName =  snapshot.child(key).child("productName").value as String // 물품 이름
                    val userUid = snapshot.child(key).child("userid").value as String // 현재 입찰자 uid
                    val buyer = snapshot.child(key).child("buyer").value as String // 구매희망자 uid
                    productList.add(Triple(productName, bitmapImage, price))
                    productList2.add(Triple(sellerName, time, userUid))
                    setBuyerUserUid(buyer)
                }
                if (productList.isNotEmpty() && productList2.isNotEmpty()) {
                    setProductList(productList.toList())
                    setProductList2(productList2.toList())
                }
            }
        }
        override fun onCancelled(error: DatabaseError) {
            // Failed to read value
            Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
        }
    } )
}

fun takeBulletinFromFirebase ( // 파이어베이스에서 게시글 정보 가져오는 함수
    setContentList: (List<Triple<String, String, Int>>) -> Unit,
    setContent: (String) -> Unit,
) {
    val database = Firebase.database
    val myRef = database.getReference("users").child("Bulletin")
    var hits = 0
    var content = ""

    myRef.addValueEventListener(object : ValueEventListener { // 데이터 한번만 받고 연결 닫는 함수
        override fun onDataChange(snapshot: DataSnapshot) {
            if (snapshot.exists()) {
                var key: String
                val bulletinList = mutableListOf<Triple<String, String, Int>>()
                for (data in snapshot.children) {
                    key = data.key as String
                    val title =  snapshot.child(key).child("title").value as String // 게시글 제목
                    val writer = snapshot.child(key).child("writer").value as String // 작성자
                    val checkHits = snapshot.child(key).child("hits").value as String// 조회수
                    content = snapshot.child(key).child("content").value as String // 게시글 내용
                    if (checkHits != "null") {
                        hits = checkHits.toInt() // null check required
                    }
                    bulletinList.add(Triple(title, writer, hits))
                }

                if (bulletinList.isNotEmpty() && content != "") {
                    setContentList(bulletinList.toList())
                    setContent(content)
                }
            }
        }
        override fun onCancelled(error: DatabaseError) {
            // Failed to read value
            Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
        }
    } )
}

fun takeNoticeInFromFirebase ( // 파이어베이스에서 공지사항 정보 가져오는 함수
    setContentList: (List<Triple<String, Int, String>>) -> Unit,
) {
    val database = Firebase.database
    val myRef = database.getReference("users").child("notice")
    var hits = 0

    myRef.addValueEventListener(object : ValueEventListener { // 데이터 한번만 받고 연결 닫는 함수
        override fun onDataChange(snapshot: DataSnapshot) {
            if (snapshot.exists()) {
                var key: String
                val bulletinList = mutableListOf<Triple<String, Int, String>>()
                for (data in snapshot.children) {
                    key = data.key as String
                    val title =  snapshot.child(key).child("title").value as String // 공지사항 제목
                    val checkHits = (snapshot.child(key).child("hits").value as String) // 조회수
                    val content = (snapshot.child(key).child("content").value as String) // 공지사항 내용
                    if (checkHits != "null") {
                        hits =  checkHits.toInt() // null check required
                    }
                    bulletinList.add(Triple(title, hits, content))
                }
                if (bulletinList.isNotEmpty()) {
                    setContentList(bulletinList.toList())
                }
            }
        }
        override fun onCancelled(error: DatabaseError) {
            // Failed to read value
            Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
        }
    } )
}

fun takeCurrentUserInfoFromFirebase(setCurrentUserMoney: (Int) -> Unit) { // 파이어베이스에서 현재 사용자의 돈을 가져오는 함수
    val database = Firebase.database
    val user = Firebase.auth.currentUser
    var userUid = ""

    if (user != null) {
        userUid = user.uid
    }

    val myRef = database.getReference("users").child("info").child(userUid).child("money")
    var money = 0

    myRef.addValueEventListener(object : ValueEventListener { // 데이터 한번만 받고 연결 닫는 함수
        override fun onDataChange(snapshot: DataSnapshot) {
            if (snapshot.exists()) {
                val checkInt = snapshot.value as String // 공지사항 내용
                if (checkInt != "null") {
                    money = checkInt.toInt() // null check required
                    setCurrentUserMoney(money)
                }
            }
        }
        override fun onCancelled(error: DatabaseError) {
            Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
        }
    } )
}

fun takeBeforeUserInfoFromFirebase(setBeforeUserMoney: (Int) -> Unit, userUid: String) { // 파이어베이스에서 전 경매자의 돈을 가져오는 함수
    val database = Firebase.database
    val beforeUserUid = userUid

    val myRef = database.getReference("users").child("info").child(beforeUserUid).child("money")
    var money = 0

    myRef.addValueEventListener(object : ValueEventListener { // 데이터 한번만 받고 연결 닫는 함수
        override fun onDataChange(snapshot: DataSnapshot) {
            if (snapshot.exists()) {
                val checkInt = snapshot.value as String // 공지사항 내용
                if (checkInt != "null") {
                    money = checkInt.toInt() // null check required
                    setBeforeUserMoney(money)
                }
            }
        }
        override fun onCancelled(error: DatabaseError) { // Failed to read value
            Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
        }
    } )
}

fun takeNoticeContentFromFirebase(setContent: (String) -> Unit) { // 파이어베이스에서 공지사항 내용 가져오는 함수
    val database = Firebase.database
    val myRef = database.getReference("users").child("notice").limitToFirst(1)

    myRef.addValueEventListener(object : ValueEventListener { // 데이터 한번만 받고 연결 닫는 함수
        override fun onDataChange(snapshot: DataSnapshot) {
            if (snapshot.exists()) {
                var key: String
                for (data in snapshot.children) {
                    key = data.key as String
                    val noviceContent =  snapshot.child(key).child("content").value as String // 공지사항 내용
                    setContent(noviceContent)
                }
            }
        }
        override fun onCancelled(error: DatabaseError) { // Failed to read value
            Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
        }
    } )
}


fun takeSellProductFromFirebase( // 현재 내가 판매중인 물품 리스트 가져오는 함수
    setProductList: (List<Triple<String, Int, Int>>) -> Unit
) {
    val database = Firebase.database
    val user = Firebase.auth.currentUser
    var userUid = ""

    if (user != null) {
        userUid = user.uid
    }
    val myRef = database.getReference("users").child("Products")
    var price = 0
    var time = 0

    myRef.addValueEventListener(object : ValueEventListener { // 데이터 상시수신대기 함수
        override fun onDataChange(snapshot: DataSnapshot) {
            if (snapshot.exists()) {
                var key: String
                val productList = mutableListOf<Triple<String, Int, Int>>()
                for (data in snapshot.children) {
                    key = data.key as String
                    val id = snapshot.child(key).child("userid").value as String // 사용자의 id 같은지 비교
                    if (id == userUid) {
                        val productName = snapshot.child(key).child("productName").value as String // 물품 이름
                        val checkPrice = (snapshot.child(key).child("price").value as String) // 물품 가격
                        if (checkPrice != "null") {
                            price =  checkPrice.toInt()
                        }
                        val checkTime = (snapshot.child(key).child("time").value as String) // 경매 남은 시간
                        if (checkTime != "null") {
                            time =  checkTime.toInt()
                        }
                        productList.add(Triple(productName, price, time))
                    }
                }
                if (productList.isNotEmpty()) {
                    setProductList(productList.toList())
                }
            }
        }
        override fun onCancelled(error: DatabaseError) {
            // Failed to read value
            Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
        }
    } )
}

fun takeMyItemFromFirebase( // 현재 내가 경매중인 물품 리스트 가져오는 함수
    setProductList: (List<Triple<String, Int, Int>>) -> Unit
) {
    val database = Firebase.database
    val user = Firebase.auth.currentUser
    var userUid = ""

    if (user != null) {
        userUid = user.uid
    }
    val myRef = database.getReference("users").child("Products")
    var price = 0
    var time = 0

    myRef.addValueEventListener(object : ValueEventListener { // 데이터 상시수신대기 함수
        override fun onDataChange(snapshot: DataSnapshot) {
            if (snapshot.exists()) {
                var key: String
                val productList = mutableListOf<Triple<String, Int, Int>>()
                for (data in snapshot.children) {
                    key = data.key as String
                    val id = snapshot.child(key).child("buyer").value as String // 사용자의 id 같은지 비교
                    if (id == userUid) {
                        val productName = snapshot.child(key).child("productName").value as String // 물품 이름
                        val checkPrice = (snapshot.child(key).child("price").value as String) // 물품 가격
                        if (checkPrice != "null") {
                            price =  checkPrice.toInt()
                        }
                        val checkTime = (snapshot.child(key).child("time").value as String) // 경매 남은 시간
                        if (checkTime != "null") {
                            time =  checkTime.toInt()
                        }
                        productList.add(Triple(productName, price, time))
                    }
                }
                if (productList.isNotEmpty()) {
                    setProductList(productList.toList())
                }
            }
        }
        override fun onCancelled(error: DatabaseError) {
            // Failed to read value
            Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
        }
    } )
}


fun takeSearchItemFromFirebase( // 파이어베이스에서 검색한 물품 가져오기
    setProductList: (List<Triple<String, Int, Int>>) -> Unit
) {
    val database = Firebase.database
    val user = Firebase.auth.currentUser
    val searchWord = searchInfo.word

    val myRef = database.getReference("users").child("Products")
    var price = 0
    var time = 0

    myRef.addValueEventListener(object : ValueEventListener { // 데이터 상시수신대기 함수
        override fun onDataChange(snapshot: DataSnapshot) {
            if (snapshot.exists()) {
                var key: String
                val productList = mutableListOf<Triple<String, Int, Int>>()
                for (data in snapshot.children) {
                    key = data.key as String
                    if(key == searchWord) {
                        val productName = snapshot.child(key).child("productName").value as String // 물품 이름
                        val checkPrice = (snapshot.child(key).child("price").value as String) // 물품 가격
                        if (checkPrice != "null") {
                            price =  checkPrice.toInt()
                        }
                        val checkTime = (snapshot.child(key).child("time").value as String) // 경매 남은 시간
                        if (checkTime != "null") {
                            time =  checkTime.toInt()
                        }
                        productList.add(Triple(productName, price, time))
                    }
                }
                if (productList.isNotEmpty()) {
                    setProductList(productList.toList())
                }
            }
        }
        override fun onCancelled(error: DatabaseError) {
            // Failed to read value
            Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
        }
    } )
}