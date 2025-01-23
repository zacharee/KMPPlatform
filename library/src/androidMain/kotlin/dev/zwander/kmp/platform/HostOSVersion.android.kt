package dev.zwander.kmp.platform

import android.os.Build

internal actual val hostOSVersion: OSVersion
    get() {
        val release = Build.VERSION.RELEASE
        val split = release.split(".")

        return OSVersion(
            major = split.getOrNull(0)?.toIntOrNull(),
            minor = split.getOrNull(1)?.toIntOrNull(),
            patch = split.getOrNull(2)?.toIntOrNull(),
            build = Build.VERSION.SDK_INT.toLong(),
        )
    }
