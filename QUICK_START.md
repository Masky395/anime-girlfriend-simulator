# 🎮 Quick Start Guide - Anime Girlfriend Simulator

## For Spectra J3 Android Device (Android 7.0+)

This guide will get you playing in under 10 minutes.

---

## Option 1: Download Pre-Built APK (EASIEST - 2 minutes)

### On Your Computer:
1. Go to: https://github.com/Masky395/anime-girlfriend-simulator/releases
2. Download the latest `app-release.apk` file
3. Connect your Spectra J3 to USB
4. Copy the APK file to your phone's Downloads folder

### On Your Spectra J3:
1. Open **Settings** → **Security**
2. Turn ON **"Unknown Sources"** or **"Install unknown apps"**
3. Open **Files** app → Navigate to **Downloads**
4. Tap the `app-release.apk` file
5. Tap **Install**
6. Wait 10-30 seconds
7. Tap **Open** to launch

---

## Option 2: Build & Install via Android Studio (5 minutes)

### Prerequisites (First Time Only):
- Download **Android Studio**: https://developer.android.com/studio
- Install it (takes ~5 minutes)
- During setup, select "Android SDK" and let it download

### Build Steps:
1. **Open Terminal/Command Prompt**

2. **Clone the project:**
   ```bash
   git clone https://github.com/Masky395/anime-girlfriend-simulator.git
   cd anime-girlfriend-simulator
   ```
   (If you don't have Git, download the ZIP from GitHub and extract it)

3. **Connect your Spectra J3 via USB**

4. **Enable USB Debugging on phone:**
   - Settings → About → Tap "Build Number" 7 times
   - Go back to Settings → Developer Options
   - Enable "USB Debugging"
   - Tap "OK" when prompted

5. **Build and Install:**
   ```bash
   ./gradlew installDebug
   ```
   (On Windows: `gradlew.bat installDebug`)

6. **Done!** The app will auto-install and open on your phone

---

## Option 3: Build APK Manually (For sharing with friends)

```bash
# In the project folder, run:
./gradlew assembleRelease

# The APK will be created at:
# app/build/outputs/apk/release/app-release.apk
```

Transfer this file to your phone and follow **Option 1** installation steps.

---

## Troubleshooting for Spectra J3

### "Unknown Sources" Not Found
- Go to **Settings** → **Apps** → **Special App Access**
- Select "Install unknown apps"
- Choose "Files" app and enable it

### USB Connection Issues
- Try a different USB cable
- Update phone drivers on Windows
- Restart both phone and computer

### App Won't Install
- Make sure you have at least **100MB free storage**
- Delete the old version first if it's already installed
- Try a different USB port

### App Crashes on Startup
- The app requires Android 7.0+ (Spectra J3 supports this)
- Try uninstalling and reinstalling
- Clear cache: Settings → Apps → Anime Girlfriend → Storage → Clear Cache

---

## How to Play Once Installed

1. **Tap the app icon** to launch "Anime Girlfriend"
2. **Interact with Luna:**
   - Tap **Idle** - Default mode
   - Tap **Happy** - She smiles (+5 affection)
   - Tap **Blush** - She blushes (+3 affection)
   - Tap **Wave** - She waves hello (+4 affection)
   - Tap **Talk** - She listens to you

3. **Watch her reactions:**
   - Her face changes based on mood
   - Dialogue updates in real-time
   - Affection meter fills up with each interaction

4. **Repeat!** Keep interacting to increase affection

---

## System Requirements
- **Android Version:** 7.0 or higher ✓ (Spectra J3 has 9.0+)
- **RAM:** 100MB minimum
- **Storage:** ~60MB free space
- **No internet required** - Works offline!

---

## Uninstall
- Long-press the app icon on home screen
- Tap **Uninstall**
- Or: Settings → Apps → Anime Girlfriend → Uninstall

---

## Need Help?

### Stuck on download?
- Check your internet connection
- Try downloading again
- Use a different browser

### APK won't open?
- Make sure file is named `app-release.apk` (not `.exe` or other format)
- File should be 50-80 MB
- Try moving it to a different folder first

### Still broken?
- Open an issue: https://github.com/Masky395/anime-girlfriend-simulator/issues
- Include your Android version and what happened

---

**That's it! Enjoy your anime girlfriend! 💕✨**
