package com.example.samplefirebasechat.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplefirebasechat.firebase.GetUsers
import com.example.samplefirebasechat.firebase.ReadMessages
import com.example.samplefirebasechat.firebase.SendMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//контроль данных
class MainViewModel : ViewModel() {
    var recipient = mutableStateOf(UserModel())
    val USER = UserModel(name = "main_user", key = "turhsn-dhhfbs-dk1")

    private var _isLoad = mutableStateOf(false)
    val isLoad
        get() = _isLoad

    //Список пользователей
    val users: MutableState<List<UserModel>> = mutableStateOf(listOf(UserModel()))

    private val _allMessages: MutableState<List<MessageModel>> =
        mutableStateOf(listOf(MessageModel()))

    val chatMessage: List<MessageModel>
        get() = _allMessages.value.filter {
            (it.keyRecipient == recipient.value.key || it.keySender == recipient.value.key)
        }

    init {
        getUsers()
        getAllMessages()
    }

    fun getUsers() {
        viewModelScope.launch {
            _isLoad.value = true
            withContext(Dispatchers.IO) {
                Thread.sleep(2000)
            }
            users.value = GetUsers()
            _isLoad.value = false
        }
    }

    fun sendText(text: String) {
        viewModelScope.launch {
            _isLoad.value = true
            withContext(Dispatchers.IO) {
                Thread.sleep(2000)
            }
            SendMessage(text = text, sender = USER.key, recipient = recipient.value.key)
            _isLoad.value = false
        }
    }

    fun getAllMessages() {
        viewModelScope.launch {
            _allMessages.value = ReadMessages(USER.key)
        }
    }
}