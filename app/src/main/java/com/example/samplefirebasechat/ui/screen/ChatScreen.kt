package com.example.samplefirebasechat.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.samplefirebasechat.model.MainViewModel

//чат с пользователем
@Composable
fun ChatScreen(viewModel: MainViewModel) {

    var message by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(viewModel.chatMessage){ item ->
                Text(text = item.text)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(value = message, onValueChange = {message = it})
            IconButton(onClick = {
                if (message.trim().isEmpty()) return@IconButton
                viewModel.sendText(message)
                message = ""
            }) {
                Icon(imageVector = Icons.Default.Send, contentDescription = "")
            }
        }
    }

    if (viewModel.isLoad.value) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}