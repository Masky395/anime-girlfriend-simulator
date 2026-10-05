# Anime Girlfriend Simulator 🌸

A lightweight Android app that simulates a cute anime companion with a stylized pseudo-3D character, mood states, affection tracking, and interactive dialogue.

## Features
- 🎨 3D-inspired anime character drawn with Compose Canvas
- 😊 Multiple moods: idle, happy, blush, wave, and talk
- 💕 Affection meter that increases with interactions
- 💬 Dynamic dialogue that changes based on mood
- 📱 Simple, mobile-friendly layout
- ⚡ Lightweight and fast performance

## Quick Download & Install

### Option 1: Download Pre-built APK (Easiest)
Pre-built APKs are available in the **Releases** section:
1. Go to [Releases](https://github.com/Masky395/anime-girlfriend-simulator/releases)
2. Download the latest `.apk` file
3. Transfer to your Android phone or emulator
4. Tap to install (enable "Install from Unknown Sources" in settings if needed)

### Option 2: Build from Source

#### Prerequisites
- **Android Studio Narwhal or newer** ([Download](https://developer.android.com/studio))
- **JDK 17** (included with Android Studio)
- **Android SDK 35** (installed via Android Studio's SDK Manager)
- **Git** ([Download](https://git-scm.com/))

#### Step-by-Step Build Guide

1. **Clone the Repository**
   ```bash
   git clone https://github.com/Masky395/anime-girlfriend-simulator.git
   cd anime-girlfriend-simulator
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Click "Open" → Select the `anime-girlfriend-simulator` folder
   - Wait for Gradle to sync (5-10 minutes on first build)

3. **Build & Run on Emulator**
   - Click **Run** → **Run 'app'**
   - Select an emulator or connected Android device
   - The app will build and launch automatically

4. **Build APK for Distribution**
   ```bash
   # Build debug APK (faster, larger)
   ./gradlew assembleDebug
   
   # Build release APK (optimized, smaller)
   ./gradlew assembleRelease
   ```
   - APKs are generated in: `app/build/outputs/apk/`
   - Transfer to your device and install

5. **Build Android App Bundle (for Play Store)**
   ```bash
   ./gradlew bundleRelease
   ```
   - Generated in: `app/build/outputs/bundle/release/`

## System Requirements
- **Minimum Android Version:** Android 7.0 (API 24)
- **Target Android Version:** Android 15 (API 35)
- **RAM:** 100MB minimum
- **Storage:** ~50MB free space

## How to Play
1. Launch the app
2. Click mood buttons to interact with your companion:
   - **Idle** — Default state
   - **Happy** — Makes her smile and increases affection +5
   - **Blush** — Makes her blush and increases affection +3
   - **Wave** — Makes her wave hello and increases affection +4
   - **Talk** — She listens to you and increases affection
3. Watch the affection meter increase with each interaction
4. See dialogue change based on her current mood

## Build Output Files
After building, you'll find:

| File | Location | Use |
|------|----------|-----|
| **Debug APK** | `app/build/outputs/apk/debug/app-debug.apk` | Testing on device |
| **Release APK** | `app/build/outputs/apk/release/app-release.apk` | Distribution/sideload |
| **Bundle** | `app/build/outputs/bundle/release/app-release.aab` | Upload to Play Store |

## Architecture
- **Framework:** Jetpack Compose (modern Android UI)
- **Language:** Kotlin
- **Rendering:** Canvas-based 2D graphics
- **State Management:** Compose remember() composables
- **Theme:** Material Design 3

## Troubleshooting

### "Gradle sync failed"
- Update Android Studio to latest version
- Delete `.gradle` and `.idea` folders
- Click "Sync Now"

### "SDK 35 not found"
- Open Android Studio → Tools → SDK Manager
- Go to SDK Platforms tab
- Install "Android 15 (API 35)"

### "adb not found" when building
- Ensure Android Studio is properly installed
- Add `ANDROID_SDK_ROOT` to your environment variables
- Restart Android Studio

### APK won't install
- Enable "Install from Unknown Sources" in phone settings (Security)
- Use `adb install path/to/app.apk` via terminal

## Future Upgrades
- 🎮 Full 3D scene using SceneView or libGDX
- 🎵 Voice lines and sound effects
- 👗 Character customization (outfits, hairstyles)
- 📖 Dating sim story progression
- 🎒 Inventory and gift system
- 🎬 Animated idle sequences
- 💾 Save/load game state
- 🌐 Online leaderboards

## Project Structure
```
anime-girlfriend-simulator/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/masky395/animegirlfriendsimulator/
│   │       │   ├── MainActivity.kt
│   │       │   ├── MainScreen.kt (UI & character drawing)
│   │       │   └── ui/theme/ (colors & typography)
│   │       └── AndroidManifest.xml
│   └── build.gradle.kts
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## Building for Different Architectures
```bash
# ARM64 (most common, ~60MB)
./gradlew assembleDebug -Pandroid.bundle.enableUncompressed=true

# x86 (emulator, ~70MB)
./gradlew assembleDebug

# Split ABIs (one per architecture)
./gradlew bundleRelease
```

## License
MIT License — feel free to modify and distribute

## Contributing
Want to add features? Fork the repo and submit a pull request!

---

**Questions?** Open an issue on GitHub or check the [Android Developer Docs](https://developer.android.com/docs)

**Enjoy your anime girlfriend simulator!** 💕
