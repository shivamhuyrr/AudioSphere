✅ TODO Document – AudioSphere
(Spotify-like features + VLC-like control)

🧭 PHASE 0 – Planning & Setup (Foundation)
Documentation

- [x] Finalize PRD
- [x] Finalize Design Document
- [ ] Finalize Tech Stack (Android, Web, Backend)
- [ ] Create GitHub repository (mono-repo or separate repos)

Repo Setup

- [ ] Setup Git branching strategy
- [x] Add README (project overview + goals)
- [x] Add TODO.md (this file)

📱 PHASE 1 – Android App (Core Client)
Project Setup

- [ ] Create Android project (Kotlin)
- [ ] Enable Jetpack Compose
- [ ] Setup MVVM architecture
- [ ] Setup Navigation component
- [ ] Setup Material You theming (dark + light)

Local Storage

- [ ] Setup Room database
- [ ] Create entities: Playlist, Favourite, ListeningHistory
- [ ] Setup DataStore
- [ ] Theme preference
- [ ] Audio settings (EQ, speed)

Audio Playback (VLC-like core)

- [ ] Integrate ExoPlayer
- [ ] Implement: Play / Pause, Seek, Queue, Repeat / Shuffle
- [ ] Background playback
- [ ] Lock screen & notification controls
- [ ] Playback speed control
- [ ] Equalizer presets
- [ ] Local audio file playback

UI Screens

- [ ] Home Screen
- [ ] Search Screen
- [ ] Library Screen
- [ ] Now Playing Screen
- [ ] Profile / Settings Screen
- [ ] Mini-player component

🌐 PHASE 2 – Web App (Client)
Setup

- [ ] Create React + TypeScript project
- [ ] Setup routing
- [ ] Setup responsive layout
- [ ] Setup global state (Context / Zustand)

Features

- [ ] Login / Signup UI
- [ ] Home (recommendations)
- [ ] Search
- [ ] Playlists
- [ ] Player (HTML5 Audio)
- [ ] Profile page

Web Audio

- [ ] Audio playback
- [ ] Seek & volume
- [ ] Lightweight visualizer (optional)

Deployment

- [ ] Deploy web app to Vercel
- [ ] Add environment variables
- [ ] Test production build

☁️ PHASE 3 – Backend (Spotify-like features)
Backend Setup

- [ ] Initialize Node.js project
- [ ] Setup Express server
- [ ] Setup environment config
- [ ] Enable CORS

Authentication

- [ ] User signup API
- [ ] User login API
- [ ] Password hashing (bcrypt)
- [ ] JWT token generation
- [ ] JWT middleware

Database (MongoDB Atlas)

- [ ] Setup MongoDB cluster
- [ ] Define schemas: User, Playlist, Favourite, ListeningHistory
- [ ] Create indexes (userId, timestamps)

Core APIs

- [ ] Create playlist
- [ ] Update playlist
- [ ] Delete playlist
- [ ] Add / remove song
- [ ] Mark favourite
- [ ] Fetch user library
- [ ] Save listening history

Recommendations (Spotify-lite)

- [ ] Track play counts
- [ ] Track recent listens
- [ ] Genre-based scoring
- [ ] Time-based rules
- [ ] Recommendation API endpoint

Deployment

- [ ] Deploy backend to Render
- [ ] Configure environment variables
- [ ] Test cold-start behavior
- [ ] Verify free-tier limits

🔄 PHASE 4 – Integration & Sync
Android ↔ Backend

- [ ] Signup / Login flow
- [ ] Token storage
- [ ] Sync playlists
- [ ] Sync favourites
- [ ] Sync history

Web ↔ Backend

- [ ] Auth integration
- [ ] Playlist sync
- [ ] Recommendation fetch

🧪 PHASE 5 – Testing & Stability
Android

- [ ] ViewModel unit tests
- [ ] Audio edge cases
- [ ] Offline handling
- [ ] App lifecycle handling

Backend

- [ ] API testing (Postman)
- [ ] Auth edge cases
- [ ] Invalid token handling

Web

- [ ] Responsive testing
- [ ] Audio playback testing
- [ ] Auth session testing

🚀 PHASE 6 – Final Polish & Resume
Product Polish

- [ ] UI consistency
- [ ] Error messages
- [ ] Loading states
- [ ] Empty states

Documentation

- [ ] Update README with: Architecture, Tech stack, Screenshots
- [ ] Add API documentation
- [ ] Add setup instructions

Resume & Interview

- [ ] Prepare resume bullet points
- [ ] Prepare architecture explanation
- [ ] Prepare backend justification
- [ ] Prepare “Spotify + VLC” pitch
