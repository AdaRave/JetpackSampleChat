package com.example.samplefirebasechat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.samplefirebasechat.model.MainViewModel
import com.example.samplefirebasechat.ui.screen.ChatListScreen
import com.example.samplefirebasechat.ui.theme.SampleFirebaseChatTheme

class MainActivity : ComponentActivity() {
    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //обращение к графу для перехода к новому экрану
            NavGraph(viewModel = viewModel)
        }

    }
}

