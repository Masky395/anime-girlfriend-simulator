package com.masky395.animegirlfriendsimulator

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.unit.dp

enum class CharacterMood {
    IDLE,
    HAPPY,
    BLUSH,
    WAVE,
    TALK
}

@Composable
fun MainScreen() {
    var mood by remember { mutableStateOf(CharacterMood.IDLE) }
    var affection by remember { mutableStateOf(72) }

    val dialogueMap = mapOf(
        CharacterMood.IDLE to "I’m here to keep you company...",
        CharacterMood.HAPPY to "Hehe, you always make me smile when you’re around!",
        CharacterMood.BLUSH to "W-why are you staring at me like that?",
        CharacterMood.WAVE to "Hi! Let’s have a cute little adventure today!",
        CharacterMood.TALK to "Tell me about your day, and I’ll listen closely."
    )

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Luna",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = "Affection ${affection}%",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            CharacterScene(
                mood = mood,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(420.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color(0xFF1E1B4B),
                                Color(0xFF0F172A),
                                Color(0xFF111827)
                            )
                        ),
                        shape = RoundedCornerShape(28.dp)
                    )
            )

            Text(
                text = dialogueMap[mood] ?: dialogueMap[CharacterMood.IDLE].orEmpty(),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            LinearProgressIndicator(
                progress = { affection / 100f },
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                MoodButton(label = "Idle") {
                    mood = CharacterMood.IDLE
                }
                MoodButton(label = "Happy") {
                    mood = CharacterMood.HAPPY
                    affection = (affection + 5).coerceAtMost(100)
                }
                MoodButton(label = "Blush") {
                    mood = CharacterMood.BLUSH
                    affection = (affection + 3).coerceAtMost(100)
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                MoodButton(label = "Wave") {
                    mood = CharacterMood.WAVE
                    affection = (affection + 4).coerceAtMost(100)
                }
                MoodButton(label = "Talk") {
                    mood = CharacterMood.TALK
                }
            }
        }
    }
}

@Composable
private fun MoodButton(label: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.weight(1f),
    ) {
        Text(label)
    }
}

@Composable
fun CharacterScene(mood: CharacterMood, modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height
            val centerX = width / 2f

            val bgGlow = Color(0xFF8B5CF6).copy(alpha = 0.30f)
            drawCircle(
                color = bgGlow,
                radius = width * 0.30f,
                center = Offset(centerX, height * 0.28f)
            )

            val platformColor = Color(0xFF101827)
            drawOval(
                color = platformColor,
                topLeft = Offset(width * 0.18f, height * 0.77f),
                size = Size(width * 0.64f, height * 0.12f)
            )

            val shadowColor = Color(0xFF030712).copy(alpha = 0.35f)
            drawOval(
                color = shadowColor,
                topLeft = Offset(width * 0.37f, height * 0.72f),
                size = Size(width * 0.26f, height * 0.08f)
            )

            val skin = Color(0xFFF8D7C6)
            val hair = Color(0xFF21142C)
            val body = Color(0xFFFFD6E9)
            val outfit = Color(0xFF7C3AED)
            val skirt = Color(0xFFEC4899)
            val leg = Color(0xFF2D1A40)
            val shoe = Color(0xFFF8FAFC)
            val blush = Color(0xFFFF8FB1)
            val eye = Color(0xFF1F2937)
            val mouth = Color(0xFFB91C1C)

            val headCenter = Offset(centerX, height * 0.30f)
            val headSize = Size(150f, 150f)
            val headRect = Rect(headCenter.x - headSize.width / 2, headCenter.y - headSize.height / 2, headCenter.x + headSize.width / 2, headCenter.y + headSize.height / 2)

            drawOval(
                color = hair,
                topLeft = Offset(headRect.left - 8f, headRect.top - 10f),
                size = Size(headSize.width + 16f, headSize.height + 18f)
            )

            val hairFront = Path().apply {
                moveTo(headRect.left + 10f, headRect.top + 55f)
                lineTo(headRect.right - 10f, headRect.top + 55f)
                lineTo(headRect.right - 4f, headRect.bottom - 5f)
                lineTo(headRect.left + 4f, headRect.bottom - 5f)
                close()
            }
            drawPath(hairFront, color = hair)

            drawOval(
                color = skin,
                topLeft = Offset(headRect.left + 8f, headRect.top + 12f),
                size = Size(headSize.width - 16f, headSize.height - 12f)
            )

            val bodyTop = height * 0.46f
            val bodyLeft = centerX - 78f
            val bodyRight = centerX + 78f
            drawRoundRect(
                color = body,
                topLeft = Offset(bodyLeft, bodyTop),
                size = Size(156f, 120f),
                cornerRadius = CornerRadius(42f)
            )

            drawRoundRect(
                color = outfit,
                topLeft = Offset(bodyLeft + 20f, bodyTop + 45f),
                size = Size(116f, 80f),
                cornerRadius = CornerRadius(20f)
            )

            drawRoundRect(
                color = skirt,
                topLeft = Offset(bodyLeft - 8f, bodyTop + 110f),
                size = Size(172f, 72f),
                cornerRadius = CornerRadius(30f)
            )

            drawRoundRect(
                color = leg,
                topLeft = Offset(centerX - 36f, bodyTop + 165f),
                size = Size(30f, 80f),
                cornerRadius = CornerRadius(16f)
            )
            drawRoundRect(
                color = leg,
                topLeft = Offset(centerX + 6f, bodyTop + 165f),
                size = Size(30f, 80f),
                cornerRadius = CornerRadius(16f)
            )

            drawRoundRect(
                color = shoe,
                topLeft = Offset(centerX - 52f, height * 0.80f),
                size = Size(62f, 20f),
                cornerRadius = CornerRadius(10f)
            )
            drawRoundRect(
                color = shoe,
                topLeft = Offset(centerX + 8f, height * 0.80f),
                size = Size(62f, 20f),
                cornerRadius = CornerRadius(10f)
            )

            val armY = bodyTop + 35f
            val leftArmX = bodyLeft - 26f
            val rightArmX = bodyRight + 6f

            if (mood == CharacterMood.WAVE) {
                drawRoundRect(
                    color = skin,
                    topLeft = Offset(leftArmX - 20f, armY - 12f),
                    size = Size(90f, 24f),
                    cornerRadius = CornerRadius(12f)
                )
                drawRoundRect(
                    color = skin,
                    topLeft = Offset(centerX + 78f, height * 0.20f),
                    size = Size(24f, 90f),
                    cornerRadius = CornerRadius(12f)
                )
            } else {
                drawRoundRect(
                    color = skin,
                    topLeft = Offset(leftArmX - 18f, armY),
                    size = Size(90f, 24f),
                    cornerRadius = CornerRadius(12f)
                )
                drawRoundRect(
                    color = skin,
                    topLeft = Offset(rightArmX, armY),
                    size = Size(90f, 24f),
                    cornerRadius = CornerRadius(12f)
                )
            }

            val eyeLeft = Offset(centerX - 25f, height * 0.29f)
            val eyeRight = Offset(centerX + 25f, height * 0.29f)
            drawOval(color = eye, center = eyeLeft, radius = 8f)
            drawOval(color = eye, center = eyeRight, radius = 8f)

            if (mood == CharacterMood.BLUSH) {
                drawCircle(color = blush.copy(alpha = 0.45f), center = Offset(centerX - 42f, height * 0.34f), radius = 14f)
                drawCircle(color = blush.copy(alpha = 0.45f), center = Offset(centerX + 42f, height * 0.34f), radius = 14f)
            }

            if (mood == CharacterMood.HAPPY || mood == CharacterMood.WAVE) {
                drawArc(
                    color = mouth,
                    startAngle = 15f,
                    sweepAngle = 150f,
                    useCenter = false,
                    topLeft = Offset(centerX - 22f, height * 0.38f),
                    size = Size(44f, 26f),
                    style = Stroke(width = 4f)
                )
            } else if (mood == CharacterMood.TALK) {
                drawRoundRect(
                    color = mouth,
                    topLeft = Offset(centerX - 12f, height * 0.40f),
                    size = Size(24f, 10f),
                    cornerRadius = CornerRadius(5f)
                )
            } else {
                drawLine(
                    color = mouth,
                    start = Offset(centerX - 14f, height * 0.40f),
                    end = Offset(centerX + 14f, height * 0.40f),
                    strokeWidth = 3f
                )
            }

            if (mood == CharacterMood.TALK) {
                withTransform({
                    translate(left = centerX + 10f, top = height * 0.27f)
                    rotate(90f)
                }) {
                    drawRoundRect(
                        color = Color(0xFFFFE4E6),
                        topLeft = Offset(0f, 0f),
                        size = Size(18f, 22f),
                        cornerRadius = CornerRadius(8f)
                    )
                }
            }

            if (mood == CharacterMood.BLUSH || mood == CharacterMood.HAPPY) {
                drawOval(
                    color = Color(0xFFF9A8D4).copy(alpha = 0.25f),
                    topLeft = Offset(centerX - 66f, height * 0.52f),
                    size = Size(132f, 60f)
                )
            }
        }
    }
}
