package com.masky395.animegirlfriendsimulator

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

enum class CharacterMood {
    IDLE, HAPPY, BLUSH, WAVE, TALK, SLEEP, ANGRY, SAD
}

enum class GameScreen {
    HOME, GAMEPLAY, SHOP, INVENTORY, SETTINGS
}

data class GameState(
    val mood: CharacterMood = CharacterMood.IDLE,
    val affection: Int = 0,
    val energy: Int = 100,
    val happiness: Int = 50,
    val level: Int = 1,
    val coins: Int = 500,
    val currentScreen: GameScreen = GameScreen.HOME,
    val outfitIndex: Int = 0,
    val gifts: List<String> = emptyList(),
    val playtimeSeconds: Long = 0L
)

class GameViewModel : ViewModel() {
    private val _gameState = MutableStateFlow(GameState())
    val gameState: StateFlow<GameState> = _gameState

    fun updateMood(newMood: CharacterMood) {
        val currentState = _gameState.value
        var affectionIncrease = 0
        var energyDecrease = 5
        var happinessIncrease = 0

        when (newMood) {
            CharacterMood.HAPPY -> {
                affectionIncrease = 5
                happinessIncrease = 15
            }
            CharacterMood.BLUSH -> {
                affectionIncrease = 3
                happinessIncrease = 10
            }
            CharacterMood.WAVE -> {
                affectionIncrease = 4
                happinessIncrease = 8
            }
            CharacterMood.TALK -> {
                affectionIncrease = 2
                happinessIncrease = 5
            }
            CharacterMood.IDLE -> {
                energyDecrease = 0
            }
            else -> {}
        }

        _gameState.value = currentState.copy(
            mood = newMood,
            affection = (currentState.affection + affectionIncrease).coerceIn(0, 1000),
            energy = (currentState.energy - energyDecrease).coerceAtLeast(0),
            happiness = (currentState.happiness + happinessIncrease).coerceIn(0, 100)
        )

        // Level up every 100 affection points
        if (_gameState.value.affection % 100 == 0 && _gameState.value.affection > 0) {
            levelUp()
        }
    }

    fun navigateTo(screen: GameScreen) {
        _gameState.value = _gameState.value.copy(currentScreen = screen)
    }

    fun addGift(giftName: String) {
        val currentState = _gameState.value
        _gameState.value = currentState.copy(
            gifts = currentState.gifts + giftName,
            coins = (currentState.coins - 100).coerceAtLeast(0),
            affection = (currentState.affection + 10).coerceIn(0, 1000)
        )
    }

    fun changeOutfit(outfitIndex: Int) {
        _gameState.value = _gameState.value.copy(outfitIndex = outfitIndex)
    }

    private fun levelUp() {
        val currentState = _gameState.value
        _gameState.value = currentState.copy(
            level = currentState.level + 1,
            coins = currentState.coins + 100,
            energy = 100
        )
    }

    fun restoreEnergy() {
        val currentState = _gameState.value
        _gameState.value = currentState.copy(
            energy = 100,
            happiness = (currentState.happiness + 20).coerceIn(0, 100)
        )
    }

    fun increasePlaytime() {
        val currentState = _gameState.value
        _gameState.value = currentState.copy(
            playtimeSeconds = currentState.playtimeSeconds + 1
        )
    }
}
