package com.example.samplefirebasechat.firebase

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.samplefirebasechat.model.UserModel
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase

//получение списка пользователей
fun GetUsers(): SnapshotStateList<UserModel> {
    val _users = mutableStateListOf<UserModel>()

    try {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("users")

        myRef.addChildEventListener(object : ChildEventListener{
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val _value = snapshot.getValue(UserModel::class.java)
                if (_value != null) _users.add(_value)
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                TODO("Not yet implemented")
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    } catch (e: Exception) {
        println("Error: ${e.message}")
    }

    return _users
}