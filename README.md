# KMPPlatform
Various platform utilities for Kotlin Multiplatform, such as for retrieving the current host OS and architecture.

Supported platforms:
- Android
- Android Native (x86, x64, ARM32, ARM64)
- JVM
- iOS (x64, ARM64)
- macOS native (x64, ARM64)
- tvOS (x64, ARM64)
- watchOS (x64, ARM32, ARM64)
- JS (Browser)
- Web Assembly (Browser)
- MinGW (x64)
- Linux (x64, ARM64)

## Installation
![Maven Central Version](https://img.shields.io/maven-central/v/dev.zwander/kmpplatform)

Add the dependency to your `commonMain` source set:

```kotlin
sourceSets {
    val commonMain by getting {
        dependencies {
            implementation("dev.zwander:kmpplatform:VERSION")
        }
    }
}
```
