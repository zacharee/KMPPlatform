package dev.zwander.kmp.platform

/**
 * The operating system the application is currently running on.
 */
enum class HostOS(val id: String) {
    Android("android"),
    Linux("linux"),
    Windows("windows"),
    MacOS("macos"),
    IOS("ios"),
    TvOS("tvos"),
    WatchOS("watchos"),
    Unknown("unknown"),
    ;

    companion object {
        val current: HostOS
            get() = hostOS
    }
}

internal expect val hostOS: HostOS
