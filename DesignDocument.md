🎧 Cross-Platform Design Document
(Android App · Web App · Backend)

1. Product Overview
Product Name
(Working Name): AudioSphere
(Spotify-like streaming + VLC-like control)

Product Type
Music Discovery & Playback Platform

Cloud-based personalization (Spotify)

Local & advanced playback control (VLC)

Platforms (Phase-1)
📱 Android Application
💻 Web Application (Desktop + Tablet)
☁️ Backend API (Auth + Data Sync)

(iOS planned in future)

Target Users
Casual music listeners

Power users who want audio control

Students / indie music lovers

Users with multiple devices

1. Goals & Objectives
Business / Product Goals
Enable user accounts & personalization

Cloud-saved playlists and favourites

Intelligent auto-suggestions

Seamless sync across devices

Combine discovery + control in one app

User Goals
Discover new music quickly

Save playlists & favourites permanently

Resume listening across devices

Control playback deeply (EQ, speed)

Simple, fast, clutter-free UI

1. Design Principles
Principle Description
🎯 Clarity Clean hierarchy, no clutter
⚡ Performance Fast search & playback
🧠 Familiarity Spotify-like UX patterns
🎚️ Power VLC-style audio control
🔄 Consistency Same mental model everywhere
♿ Accessibility Readable, contrast-safe UI
2. Information Architecture
Core Sections (Android & Web)
Home
 ├── Trending
 ├── Personalized Recommendations
 ├── Recently Played

Search
 ├── Songs
 ├── Artists
 ├── Playlists

Library
 ├── Favourites
 ├── Playlists
 ├── Listening History

Now Playing
 ├── Queue
 ├── Audio Controls
 ├── Visualizer (optional)

Profile / Settings
 ├── Account
 ├── Preferences
 ├── Audio Settings
5. Platform-Wise Design Strategy
📱 Android App (Kotlin + Jetpack Compose)
Navigation
Bottom Navigation Bar

Gesture-based back navigation

Persistent mini-player

UI Characteristics
Material You (dynamic theming)

Dark-first design

Elevation & ripple feedback

Smooth animations (Compose)

Now Playing Experience
Mini-player always visible

Expandable full-screen player

Notification & lock-screen controls

Advanced audio controls (VLC-like)

💻 Web Application (React)
Layout
Sidebar navigation (desktop)

Top bar: Search + Profile

Responsive grid layout

Breakpoints
Device Width
Mobile < 768px
Tablet 768–1024px
Desktop > 1024px
Web-Specific Features
Keyboard shortcuts

Hover interactions

Multi-column browsing

Lightweight audio visualizer

1. Key Screens & Components
1️⃣ Home Screen
Hero playlists

Auto-suggested tracks

Recently played

2️⃣ Search
Instant search results

Category filters

Song & artist cards

3️⃣ Track Detail
Artwork

Metadata

Like / Add to Playlist

Play / Queue

4️⃣ Player (Core USP)
Play / Pause / Seek

Repeat / Shuffle

Speed control

Equalizer presets

Channel balance

(Android: deeper audio control)

5️⃣ Profile
User info

Saved playlists

Listening stats

Preferences

1. Backend Design (Spotify-like Layer)
Purpose of Backend
User authentication

Save playlists & favourites

Listening history

Auto-suggestions

Cross-device sync

Backend Responsibilities
✅ Store metadata & user data
❌ Store or stream audio files

Audio playback remains client-side.

High-Level Backend Architecture
Android App ─┐
             ├── REST API (Node.js)
Web App ─────┘
                  ↓
            MongoDB Atlas
8. Data Model (Simplified)
User
id

email

passwordHash

createdAt

Playlist
userId

name

trackIds[]

Favourite
userId

trackId

Listening History
userId

trackId

timestamp

1. Recommendation Strategy (Spotify-Lite)
Rule-Based Suggestions
Most played genres

Recently played artists

Time-based listening habits

Favourite overlap

(No heavy ML — free-tier friendly)

1. Design Constraints & Trade-Offs
No mainstream copyrighted catalog

### Audio Engine (Android)

- **Core**: `androidx.media3:media3-exoplayer` for playback.
- **Effects**: `android.media.audiofx` for Equalizer and Virtualizer.
- **Service**: Foreground Service for background playback and notification handling.
- **Architecture**: `MediaSessionService` to expose controls to system and other apps (Google Assistant, Bluetooth).

### Data Source Strategy (Phase 1)

- **Metadata**: Stored in MongoDB (User playlists, history).
- **Audio Files**:
  - *Primary*: Mock data / Creative Commons API (e.g., Jamendo, FMA) for demo.
  - *Local*: `MediaStore` API to access files on device.
  - *Future*: YouTube DL / Spotify SDK (if legal/feasible).

Rule-based recommendations only

Free-tier hosting limits respected

Focus on learning + clarity over scale

1. Tech Stack Summary
Android
Language: Kotlin

UI: Jetpack Compose

Architecture: MVVM

Audio: ExoPlayer

Storage: Room + DataStore

Web
React + TypeScript

HTML5 Audio / Web Audio API

Vercel (frontend hosting)

Backend
Node.js + Express

JWT Authentication

MongoDB Atlas (Free tier)

Render (Free tier)

1. Accessibility & Performance
High-contrast themes

Large touch targets

Lazy loading

Skeleton loaders

Offline-first Android behaviour

Smooth 60fps animations

1. Success Metrics
User retention

Playlist creation rate

Search success rate

Playback completion

Cross-device sync usage

1. Future Enhancements
iOS app

Advanced ML recommendations

Lyrics support

Creator analytics

Social sharing
