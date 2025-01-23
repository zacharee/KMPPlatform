package dev.zwander.kmp.platform

data class OSVersion(
    val major: Int?,
    val minor: Int?,
    val patch: Int?,
    val build: Long?,
) {
    companion object {
        val Unknown = OSVersion(null, null, null, null)

        val current: OSVersion
            get() = hostOSVersion
    }
}

internal expect val hostOSVersion: OSVersion
