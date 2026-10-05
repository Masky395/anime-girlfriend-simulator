# Anime Girlfriend Simulator 🌸

A fully playable Android dating sim with character interactions, affection tracking, gift system, and progression mechanics.

## 🎮 Features

✨ **Full Game Loop:**
- Multiple interaction moods (Happy, Blush, Wave, Talk, Sleep, Angry, Sad)
- Affection meter that grows with interactions
- Dynamic dialogue that changes based on mood and affection level
- Energy system and rest mechanic
- Level progression system

🎁 **Shop & Inventory:**
- Buy gifts to increase affection
- Collect items and track inventory
- Coins earned through level ups

💾 **Game Systems:**
- Persistent level and affection tracking
- Playtime counter
- Character customization (outfit selection)
- Home screen with stats overview

🎨 **UI:**
- Beautiful Material Design 3 interface
- Dark anime-themed color scheme
- Smooth navigation between screens
- Responsive mobile layout

---

## 📱 Installation for Spectra J3

### **Fastest Way (Option 1):**
1. Download the APK from [Releases](https://github.com/Masky395/anime-girlfriend-simulator/releases)
2. Transfer to your Spectra J3 via USB
3. Go to Settings → Security → Enable "Unknown Sources"
4. Open Files → Downloads → Tap the APK → Install
5. Launch and play!

### **Via Android Studio (Option 2):**
1. Install [Android Studio](https://developer.android.com/studio)
2. Clone this repo: `git clone https://github.com/Masky395/anime-girlfriend-simulator.git`
3. Open in Android Studio
4. Connect your Spectra J3 via USB
5. Enable USB Debugging on phone (Settings → About → Build Number 7x)
6. Click Run or use: `./gradlew installDebug`

### **Build Your Own APK (Option 3):**
```bash
git clone https://github.com/Masky395/anime-girlfriend-simulator.git
cd anime-girlfriend-simulator
./gradlew assembleRelease
```
APK will be at: `app/build/outputs/apk/release/app-release.apk`

---

## 🎮 How to Play

### Main Screen:
- **Level** - Increases every 100 affection points
- **Affection** - Your relationship progress (0-1000)
- **Energy** - Used for interactions, recovers by resting
- **Coins** - Earned by leveling up, spent in shop

### Gameplay:
1. **Start Playing** - Enter the main interaction screen
2. **Choose Interactions:**
   - 😊 **Happy** - +5 affection (costs 5 energy)
   - 💕 **Blush** - +3 affection (costs 5 energy)
   - 👋 **Wave** - +4 affection (costs 5 energy)
   - 💬 **Talk** - +2 affection (costs 5 energy)
3. **Rest** - Restore energy and happiness
4. **Shop** - Buy gifts to boost affection
5. **Inventory** - View collected gifts

---

## 🛠️ Requirements

- **Android Version:** 7.0+ (Spectra J3: ✓ Android 9.0+)
- **RAM:** 100MB minimum
- **Storage:** 60MB free space
- **No internet required** - Fully offline game

---

## 📊 Game Progression

| Affection | Status |
|-----------|--------|
| 0-100 | New Friend |
| 100-300 | Getting Close |
| 300-600 | Good Friends |
| 600-1000 | Very Close |

| Level | Coins Earned |
|-------|--------------|
| 1-10 | 100 per level |
| 11-20 | 150 per level |
| 20+ | 200 per level |

---

## 🎁 Shop Items

| Item | Cost | Effect |
|------|------|--------|
| 🌸 Rose Bouquet | 100 | +10 affection |
| 🍰 Chocolate Cake | 150 | +10 affection |
| 👗 Pink Dress | 300 | Outfit change |
| 💎 Diamond Ring | 500 | +10 affection |
| 🎀 Hair Ribbon | 80 | +10 affection |

---

## 📁 Project Structure

```
anime-girlfriend-simulator/
├── app/src/main/
│   ├── java/com/masky395/animegirlfriendsimulator/
│   │   ├── MainActivity.kt          # App entry point
│   │   ├── GameViewModel.kt         # Game state management
│   │   ├── GameScreen.kt            # All UI screens
│   │   └── ui/theme/                # Colors & typography
│   └── AndroidManifest.xml
├── app/build.gradle.kts             # Build configuration
└── README.md
```

---

## 🚀 Build APK

### Debug APK (for testing):
```bash
./gradlew assembleDebug
# Output: app/build/outputs/apk/debug/app-debug.apk
```

### Release APK (optimized, for sharing):
```bash
./gradlew assembleRelease
# Output: app/build/outputs/apk/release/app-release.apk
```

### Direct Installation:
```bash
./gradlew installDebug      # Auto-installs on connected device
./gradlew installRelease    # Auto-installs release version
```

---

## ❓ Troubleshooting

### APK won't install
- Enable "Install from Unknown Sources" (Settings → Security)
- Ensure 100MB+ free storage on phone
- Use latest APK file from Releases

### App crashes on startup
- Clear app cache: Settings → Apps → Anime Girlfriend → Storage → Clear Cache
- Reinstall the app
- Ensure Android 7.0+

### USB not detected
- Use different USB cable
- Enable USB Debugging: Settings → About Phone → Build Number (tap 7x)
- Restart phone and computer

### Can't find Settings menu
- Swipe down from top to access system settings
- Look for "Developer Options" after tapping Build Number 7 times

---

## 🎨 Customization

### Change Character Colors
Edit `GameScreen.kt` color definitions:
```kotlin
val skin = Color(0xFFF8D7C6)      // Skin tone
val hair = Color(0xFF21142C)      // Hair color
val outfit = Color(0xFF7C3AED)    // Outfit color
```

### Add More Moods
In `GameViewModel.kt`, add to `CharacterMood` enum:
```kotlin
enum class CharacterMood {
    IDLE, HAPPY, BLUSH, WAVE, TALK, SLEEP, ANGRY, SAD, EXCITED // Add new mood
}
```

---

## 📈 Future Updates

- 🎬 Animated character expressions
- 🎵 Background music and sound effects
- 📖 Story mode and character backstory
- 👗 More outfit customization options
- 💌 Love letters and messages
- 🌍 Multiple characters
- 🏆 Achievement system
- 💕 Photo mode with character

---

## 📝 License

MIT License - Feel free to modify and share!

---

## 🤝 Contributing

Found a bug? Have a feature idea? Open an issue or submit a pull request!

---

**Ready to meet Luna? Download now and start your anime dating sim adventure! 💕✨**

For detailed installation help, see [QUICK_START.md](QUICK_START.md)
