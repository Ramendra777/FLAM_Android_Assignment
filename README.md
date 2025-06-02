# 📘 Android Assignment - Set 1 (Q1, Q2, Q4)

This repository contains solutions to selected questions from the Android Assignment Set 1. The solutions are implemented in Java and follow clean, maintainable structures.

---

## ✅ Q1: Least Recently Used (LRU) Cache

### 🧠 Description
Implements a fixed-size LRU Cache where the least recently used entry is removed when capacity is exceeded.

### 📂 Folder/File
- `Q1.java`

### 📌 Features
- O(1) time complexity for both `get(key)` and `put(key, value)`
- Uses `HashMap` and a doubly linked list internally

### ▶️ Example
```java
LRUCache lru = new LRUCache(2);
lru.put(1, 1);
lru.put(2, 2);
lru.get(1);     // returns 1
lru.put(3, 3);   // evicts key 2
lru.get(2);     // returns -1
```

---

## ✅ Q2: Custom HashMap Implementation

### 🧠 Description
Reimplements a simplified HashMap using chaining (linked lists) without built-in collections like `HashMap`, `Map`, or `Dict`.

### 📂 Folder/File
- `Q2.java`

### 📌 Features
- Average-case O(1) for `put`, `get`, and `remove`
- Uses a fixed-size bucket array with separate chaining

### ▶️ Example
```java
MyHashMap obj = new MyHashMap();
obj.put(1, 10);
obj.put(2, 20);
System.out.println(obj.get(1)); // 10
obj.remove(2);
System.out.println(obj.get(2)); // -1
```

---

## ✅ Q4: OpenGL Mini Solar System (Android)

### 🧠 Description
Renders a simple solar system using OpenGL ES 2.0. Includes one static Sun, two orbiting planets, and one moon.

### 📂 Folder
- `Q4_SolarSystem`

### 📌 Features
- Sun at center
- Two planets rotating at different speeds/distances
- One moon orbiting the second planet
- Custom shaders (GLSL) for rendering
- Matrix transformations for orbit and rotation

### 📁 Core Files
- `MainActivity.java` – sets up `GLSurfaceView`
- `MyGLSurfaceView.java` – connects renderer
- `SolarSystemRenderer.java` – all transformation and drawing logic
- `vertex_shader.glsl`, `fragment_shader.glsl` – simple color shaders

### ▶️ Tech Stack
- Java
- OpenGL ES 2.0
- Android GLES20 API
- GLSL

### 🚀 How to Run
1. Open in Android Studio
2. Make sure `minSdkVersion` is 21 or higher
3. Run on emulator or physical device

---

## 📦 Build Instructions (for All)

### 🔨 With Android Studio
1. Open project folder
2. Sync Gradle
3. Click Run ▶️ to deploy to emulator/device

### 🏗 With VS Code (Advanced)
- Install JDK + Android SDK
- Set `ANDROID_HOME`
- Use `./gradlew assembleDebug` to build APK

---


