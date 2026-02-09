# AudioSphere 🎧

**AudioSphere** is a modern, cross-platform music experience that bridges the gap between cloud streaming and local playback.

It combines:

- **Spotify-like Discovery**: Personalized recommendations, cloud playlists, and history.
- **VLC-like Control**: Advanced audio engine (ExoPlayer), equalizer, and local file management.

## 🚀 Features

### Core

- **Cross-Platform**: Seamless experience on Android and Web.
- **Cloud Sync**: Playlists, History, and Likes synced across devices.
- **Privacy First**: No tracking, local-first for offline media.

### Android App

- **Material You Design**: Beautiful, adaptive UI built with Jetpack Compose.
- **Advanced Playback**: Speed control, Equalizer, and Background play.
- **Local Library**: Scan and play local audio files with high fidelity.

### Web App

- **Responsive Design**: Built with React and Tailwind for all screen sizes.
- **Keyboard Shortcuts**: Power-user friendly controls.

## 🛠 Tech Stack

| Component | Technology |
|-----------|------------|
| **Android** | Kotlin, Jetpack Compose, Media3 (ExoPlayer), Room, Retrofit |
| **Web** | React, TypeScript, Tailwind CSS, Vite |
| **Backend** | Node.js, Express, MongoDB Atlas, JWT |
| **Design** | Material You (Android), Modern Dark Theme (Web) |

## 📂 Project Structure

```
/AudioSphere
  ├── /android      # Native Android Application (Kotlin/Compose)
  ├── /web          # Web Client (React/Vite)
  ├── /backend      # API Server (Node.js/Express)
```

## ⚡ Getting Started

### Backend

```bash
cd backend
npm install
# Create .env file with MONGODB_URI and JWT_SECRET
npm start
```

### Web

```bash
cd web
npm install
npm run dev
```

### Android

Open the `/android` directory in Android Studio and sync Gradle.
