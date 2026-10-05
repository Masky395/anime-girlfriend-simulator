package com.masky395.animegirlfriendsimulator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.masky395.animegirlfriendsimulator.ui.theme.AnimeGirlfriendSimulatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimeGirlfriendSimulatorTheme {
                MainScreen()
            }
        }
    }
}
