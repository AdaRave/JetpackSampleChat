package com.example.samplefirebasechat

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.samplefirebasechat.model.MainViewModel
import com.example.samplefirebasechat.ui.screen.ChatListScreen
import com.example.samplefirebasechat.ui.screen.ChatScreen

//навигация
@Composable
fun NavGraph(viewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "chat_list" ){
        composable("chat_list"){
            ChatListScreen(viewModel = viewModel, navController)
        }
        composable("chat"){
            ChatScreen(viewModel)
        }
    }
}