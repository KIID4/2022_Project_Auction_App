package io.github.KIID_4.auction.ui.function

import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

fun updateInfo(useruid: String) {
    val user = Firebase.auth.currentUser
    var name = ""

    val database = Firebase.database
    val myRef = database.getReference("users").child("info").child(useruid).child("name")


    myRef.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            name = snapshot.value as String

            val profileUpdates = userProfileChangeRequest {
                displayName = name
            }

            if (user != null) {
                user.updateProfile(profileUpdates)
            }
        }

        override fun onCancelled(error: DatabaseError) {
        }
    } )

}