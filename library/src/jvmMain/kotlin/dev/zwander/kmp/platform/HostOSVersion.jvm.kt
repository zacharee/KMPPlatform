package dev.zwander.kmp.platform

internal actual val hostOSVersion: OSVersion
    get() {
        val versionInfo = oshi.SystemInfo().operatingSystem.versionInfo
        val version = versionInfo.version
        val build = versionInfo.buildNumber
        val split = version.split(".")

        return OSVersion(
            major = split.getOrNull(0)?.toIntOrNull(),
            minor = split.getOrNull(1)?.toIntOrNull(),
            patch = split.getOrNull(2)?.toIntOrNull(),
            build = build?.toLongOrNull(),
        )
    }
