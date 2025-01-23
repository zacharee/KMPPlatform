package dev.zwander.kmp.platform

internal actual val hostArch: HostArch
    get() {
        return when (val osArch = System.getProperty("os.arch")) {
            "x86_64", "amd64" -> HostArch.X64
            "aarch64" -> HostArch.Arm64
            else -> throw Error("Unknown arch $osArch")
        }
    }
