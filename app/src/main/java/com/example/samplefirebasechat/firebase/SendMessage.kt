package com.example.samplefirebasechat.firebase

import com.example.samplefirebasechat.model.MessageModel
import com.google.firebase.database.FirebaseDatabase

//отправка сообщений
fun SendMessage(text: String, recipient: String, sender: String) {
    try {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("messages")

        myRef.push()
            .setValue(MessageModel(text = text, keyRecipient = recipient, keySender = sender))

    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}