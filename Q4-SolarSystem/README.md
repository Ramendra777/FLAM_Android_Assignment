# 🌌 Q4 - Mini Solar System Visualization (Android OpenGL ES 2.0)

This project is a mini solar system implemented in **Java using OpenGL ES 2.0** for Android. It includes:
- A central glowing Sun
- Two orbiting planets
- One moon orbiting a planet
- Full 3D transformations and touch interactions

---

## 🚀 Features
- OpenGL ES 2.0 rendering pipeline
- Shader-based glow and color
- Rotation + Orbit animations
- View control using touch
- Custom Sphere generation using VBO

---

## 🧱 Architecture
- `MainActivity.java`: Entry point and GLSurfaceView setup
- `SolarSystemRenderer.java`: Main render loop and object transforms
- `ShaderUtils.java`: Utility class for shader handling
- `Sphere.java`: Generates 3D sphere geometry
- `res/raw/*.glsl`: GLSL vertex and fragment shaders

---

## 📂 Folder Structure
```
Q4/
├── app/
│   ├── java/com/example/solarsystem/
│   │   ├── MainActivity.java
│   │   ├── SolarSystemRenderer.java
│   │   ├── ShaderUtils.java
│   │   └── Sphere.java
│   └── res/raw/
│       ├── sun_vertex.glsl
│       ├── sun_fragment.glsl
│       ├── planet_vertex.glsl
│       └── planet_fragment.glsl
```

---

## 🛠️ build.gradle (Module)
```gradle
dependencies {
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
}
```

```gradle
android {
    compileSdk 33

    defaultConfig {
        applicationId "com.example.solarsystem"
        minSdk 21
        targetSdk 33
        versionCode 1
        versionName "1.0"
        vectorDrawables.useSupportLibrary = true
    }
    buildFeatures {
        viewBinding true
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
}
```
