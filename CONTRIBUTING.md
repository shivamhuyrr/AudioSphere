# Contributing to AudioSphere

## Development Workflow

This project is a monorepo containing three distinct parts:

1. **Android App** (`/android`)
2. **Web App** (`/web`)
3. **Backend API** (`/backend`)

### 📱 Android Development

**Tooling:** Use **Android Studio** (Hedgehog or newer recommended).

**Why Android Studio?**
While you can edit Kotlin files in any editor (including VS Code or AI assistants), Android Studio is required to:

- **Build the APK**: It manages the Gradle build system.
- **Run the App**: It provides the Android Emulator and easy deployment to physical devices.
- **Debug**: It has powerful tools for inspecting UI layouts and memory usage.

**Setup Instructions:**

1. Open **Android Studio**.
2. Select **Open** (or "Open an existing project").
3. Navigate to the `AudioSphere/android` folder and click **OK**.
4. Wait for Gradle to sync (this downloads dependencies).
5. Select a device/emulator and click the green **Run** (▶️) button.

### 🌐 Web Development

**Tooling:** VS Code, Cursor, or Terminal.

**Setup:**

1. Navigate to `/web`.
2. Run `npm install`.
3. Run `npm run dev`.
4. Open `http://localhost:5173` in your browser.

### ☁️ Backend Development

**Tooling:** VS Code, Cursor, or Terminal.

**Setup:**

1. Navigate to `/backend`.
2. Run `npm install`.
3. Run `npm start` (or `npm run dev` for auto-restart).
4. The server API will run on `http://localhost:5000`.

## Unified Testing

To test the full system:

1. Start the **Backend** first.
2. Start the **Web App** (optional, if testing web).
3. Launch the **Android App** in Android Studio.
    - *Note for Emulator users:* The emulator sees `localhost` as the emulator itself, not your computer. Use `10.0.2.2` instead of `localhost` to reach your computer's backend.
