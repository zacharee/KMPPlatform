# KMPPlatform
Various platform utilities for Kotlin Multiplatform, such as for retrieving the current host OS and architecture.

Supported platforms:
- Android
- JVM
- iOS
- macOS native
- JS
- Web Assembly

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
