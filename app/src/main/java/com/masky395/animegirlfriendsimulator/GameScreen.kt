package com.masky395.animegirlfriendsimulator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.masky395.animegirlfriendsimulator.ui.theme.*

@Composable
fun GameScreenContent(viewModel: GameViewModel = viewModel()) {
    val gameState by viewModel.gameState.collectAsState()

    when (gameState.currentScreen) {
        GameScreen.HOME -> HomeScreen(viewModel, gameState)
        GameScreen.GAMEPLAY -> GameplayScreen(viewModel, gameState)
        GameScreen.SHOP -> ShopScreen(viewModel, gameState)
        GameScreen.INVENTORY -> InventoryScreen(viewModel, gameState)
        GameScreen.SETTINGS -> SettingsScreen(viewModel, gameState)
    }
}

@Composable
fun HomeScreen(viewModel: GameViewModel, gameState: GameState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(Color(0xFF1E1B4B), Color(0xFF0F172A))
                )
            )
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Anime Girlfriend",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = PinkPrimary
        )

        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color(0xFF1F2937), shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text("Luna", fontSize = 48.sp, fontWeight = FontWeight.Bold, color = DarkText)
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            StatRow("Level", gameState.level.toString())
            StatRow("Affection", "${gameState.affection}/1000")
            StatRow("Energy", "${gameState.energy}/100")
            StatRow("Coins", gameState.coins.toString())
        }

        Button(
            onClick = { viewModel.navigateTo(GameScreen.GAMEPLAY) },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PinkPrimary)
        ) {
            Text("Start Playing", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { viewModel.navigateTo(GameScreen.SHOP) },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                colors = ButtonDefaults.buttonColors(containerColor = VioletSecondary)
            ) {
                Text("Shop", fontSize = 14.sp)
            }
            Button(
                onClick = { viewModel.navigateTo(GameScreen.INVENTORY) },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                colors = ButtonDefaults.buttonColors(containerColor = VioletSecondary)
            ) {
                Text("Inventory", fontSize = 14.sp)
            }
            Button(
                onClick = { viewModel.navigateTo(GameScreen.SETTINGS) },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                colors = ButtonDefaults.buttonColors(containerColor = VioletSecondary)
            ) {
                Text("Settings", fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun GameplayScreen(viewModel: GameViewModel, gameState: GameState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(Color(0xFF1E1B4B), Color(0xFF0F172A))
                )
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Top bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { viewModel.navigateTo(GameScreen.HOME) },
                modifier = Modifier.size(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = VioletSecondary)
            ) {
                Text("←", fontSize = 20.sp)
            }
            Text("Luna - Level ${gameState.level}", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = DarkText)
            Text("💰 ${gameState.coins}", fontSize = 16.sp, color = PinkPrimary)
        }

        // Stats
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            ProgressBar("Affection", gameState.affection, 1000, PinkPrimary)
            ProgressBar("Energy", gameState.energy, 100, VioletSecondary)
            ProgressBar("Happiness", gameState.happiness, 100, Color(0xFFFCD34D))
        }

        // Character display
        CharacterScene(
            mood = gameState.mood,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(Color(0xFF1E1B4B), Color(0xFF0F172A))
                    ),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp)
                )
        )

        // Dialogue
        Text(
            text = getDialogue(gameState.mood, gameState.affection),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF111827), shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp))
                .padding(12.dp),
            color = DarkText,
            fontSize = 14.sp
        )

        // Action buttons
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ActionButton("😊 Happy", { viewModel.updateMood(CharacterMood.HAPPY) }, Modifier.weight(1f))
                ActionButton("💕 Blush", { viewModel.updateMood(CharacterMood.BLUSH) }, Modifier.weight(1f))
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ActionButton("👋 Wave", { viewModel.updateMood(CharacterMood.WAVE) }, Modifier.weight(1f))
                ActionButton("💬 Talk", { viewModel.updateMood(CharacterMood.TALK) }, Modifier.weight(1f))
            }
            Button(
                onClick = { viewModel.restoreEnergy() },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981))
            ) {
                Text("😴 Rest (Restore Energy)", fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun ShopScreen(viewModel: GameViewModel, gameState: GameState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFF1E1B4B), Color(0xFF0F172A))))
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { viewModel.navigateTo(GameScreen.HOME) },
                colors = ButtonDefaults.buttonColors(containerColor = VioletSecondary)
            ) {
                Text("← Back")
            }
            Text("Shop", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = PinkPrimary)
            Text("💰 ${gameState.coins}", fontSize = 16.sp, color = DarkText)
        }

        val gifts = listOf(
            "🌸 Rose Bouquet" to 100,
            "🍰 Chocolate Cake" to 150,
            "💎 Diamond Ring" to 500,
            "👗 Pink Dress" to 300,
            "🎀 Hair Ribbon" to 80
        )

        gifts.forEach { (gift, price) ->
            ShopItem(gift, price, gameState.coins >= price) {
                viewModel.addGift(gift)
            }
        }
    }
}

@Composable
fun InventoryScreen(viewModel: GameViewModel, gameState: GameState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFF1E1B4B), Color(0xFF0F172A))))
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { viewModel.navigateTo(GameScreen.HOME) },
                colors = ButtonDefaults.buttonColors(containerColor = VioletSecondary)
            ) {
                Text("← Back")
            }
            Text("Inventory (${gameState.gifts.size})", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = PinkPrimary)
        }

        if (gameState.gifts.isEmpty()) {
            Text("No gifts yet. Visit the shop!", color = DarkText, modifier = Modifier.padding(top = 20.dp))
        } else {
            gameState.gifts.forEach { gift ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF111827))
                ) {
                    Text(gift, modifier = Modifier.padding(16.dp), color = DarkText, fontSize = 16.sp)
                }
            }
        }
    }
}

@Composable
fun SettingsScreen(viewModel: GameViewModel, gameState: GameState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFF1E1B4B), Color(0xFF0F172A))))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(
            onClick = { viewModel.navigateTo(GameScreen.HOME) },
            colors = ButtonDefaults.buttonColors(containerColor = VioletSecondary)
        ) {
            Text("← Back to Home")
        }

        Text("Settings", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = PinkPrimary)
        Text("Version 1.0", color = DarkText)
        Text("Playtime: ${formatPlaytime(gameState.playtimeSeconds)}", color = DarkText)
        Text("Total Affection Earned: ${gameState.affection}", color = DarkText)
    }
}

// Helper Composables
@Composable
fun StatRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF111827), shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, color = DarkText)
        Text(value, color = PinkPrimary, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ProgressBar(label: String, current: Int, max: Int, color: Color) {
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(label, color = DarkText, fontSize = 12.sp)
            Text("$current/$max", color = color, fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
        LinearProgressIndicator(
            progress = { (current.toFloat() / max).coerceIn(0f, 1f) },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp),
            color = color,
            trackColor = Color(0xFF374151)
        )
    }
}

@Composable
fun ActionButton(label: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier.height(48.dp),
        colors = ButtonDefaults.buttonColors(containerColor = VioletSecondary)
    ) {
        Text(label, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
fun ShopItem(name: String, price: Int, canAfford: Boolean, onBuy: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF111827))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(name, color = DarkText, fontWeight = FontWeight.Bold)
                Text("💰 $price", color = PinkPrimary, fontSize = 14.sp)
            }
            Button(
                onClick = onBuy,
                enabled = canAfford,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (canAfford) PinkPrimary else Color.Gray
                )
            ) {
                Text("Buy", fontSize = 12.sp)
            }
        }
    }
}

fun getDialogue(mood: CharacterMood, affection: Int): String {
    return when (mood) {
        CharacterMood.IDLE -> {
            when {
                affection > 800 -> "I love spending time with you... 💕"
                affection > 500 -> "You're always on my mind."
                else -> "I'm here, waiting for you..."
            }
        }
        CharacterMood.HAPPY -> "Hehe, you make me so happy when you're around! 😊"
        CharacterMood.BLUSH -> "W-why are you making me feel like this? My heart is racing... 😳"
        CharacterMood.WAVE -> "Hi! Let's have an amazing day together! 👋"
        CharacterMood.TALK -> "Tell me everything about your day... I'll listen. 💬"
        CharacterMood.SLEEP -> "Zzz... sweet dreams of you... 😴"
        CharacterMood.ANGRY -> "I'm upset with you right now... 😠"
        CharacterMood.SAD -> "I miss you when you're not here... 😢"
    }
}

fun formatPlaytime(seconds: Long): String {
    val hours = seconds / 3600
    val minutes = (seconds % 3600) / 60
    return "${hours}h ${minutes}m"
}
