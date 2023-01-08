package com.example.samplefirebasechat.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.samplefirebasechat.model.MainViewModel

//список доступных для общения пользователей
@Composable
fun ChatListScreen(viewModel: MainViewModel, navController: NavController) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        items(viewModel.users.value) { user ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFB3D7F3))
                    .padding(5.dp)
                    .clickable {
                        viewModel.recipient.value = user
                        navController.navigate("chat")
                    }
                ,
                contentAlignment = Alignment.Center
            ) {
                Text(text = user.name)
            }
        }
    }

    if (viewModel.isLoad.value) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}