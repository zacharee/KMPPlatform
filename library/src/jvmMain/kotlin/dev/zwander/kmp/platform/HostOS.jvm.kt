package dev.zwander.kmp.platform

internal actual val hostOS: HostOS
    get() {
        val osName = System.getProperty("os.name")
        return when {
            osName == "Mac OS X" -> HostOS.MacOS
            osName.startsWith("Win") -> HostOS.Windows
            "The Android Project" == System.getProperty("java.specification.vendor") -> HostOS.Android
            osName == "Linux" -> HostOS.Linux
            else -> HostOS.Unknown
        }
    }