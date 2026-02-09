# AudioSphere 🎧

**AudioSphere** is a cross-platform music discovery and playback platform that combines the best of streaming (Spotify-like personalization) with the power of local media players (VLC-like advanced audio control).

## 🚀 Vision

To build a single app where users can manage their local high-quality usage library *and* discover new music from the cloud, with seamless sync across Android and Web.

## 🛠 Tech Stack

| Component | Technology |
|-----------|------------|
| **Android** | Kotlin, Jetpack Compose, Media3 (ExoPlayer), Room, Retrofit |
| **Web** | React, TypeScript, Tailwind CSS, Vite |
| **Backend** | Node.js, Express, MongoDB Atlas, JWT |
| **Design** | Material You (Android), Glassmorphism (Web) |

## 🗺 Roadmap (Phases)

See [TODO.md](./TODO.md) for the detailed checklist.

- **Phase 0**: Planning & Setup ✅
- **Phase 1**: Android App (Core Client) 🚧
- **Phase 2**: Web App (Client)
- **Phase 3**: Backend (Auth & Data) 🚧
- **Phase 4**: Integration & Sync
- **Phase 5**: Testing & Stability
- **Phase 6**: Final Polish

## 📂 Project Structure

```
/AudioSphere
  ├── /android      # Native Android application
  ├── /web          # React Web application
  ├── /backend      # Node.js API server
  ├── TODO.md       # Detailed Task Checklist
  ├── PRD.md        # Product Requirements
  └── Design...md   # UI/UX & Architecture Specs
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
