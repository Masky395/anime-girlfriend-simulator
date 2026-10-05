package com.masky395.animegirlfriendsimulator.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = PinkPrimary,
    secondary = VioletSecondary,
    tertiary = LavenderAccent,
    background = DarkBackground,
    surface = DarkPanel,
    onPrimary = DarkText,
    onSecondary = DarkText,
    onBackground = DarkText,
    onSurface = DarkText,
)

@Composable
fun AnimeGirlfriendSimulatorTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}
