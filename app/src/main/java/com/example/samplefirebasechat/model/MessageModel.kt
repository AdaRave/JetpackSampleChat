package com.example.samplefirebasechat.model

//модель сообщения
data class MessageModel(
    val text: String = "",
    val keySender: String = "",
    val keyRecipient: String = ""
)
