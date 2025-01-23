package dev.zwander.kmp.platform

/**
 * The CPU architecture of the host system.
 */
enum class HostArch(val id: String) {
    /**
     * Intel x86.
     */
    X86("x86"),

    /**
     * AMD64
     * x86_64
     */
    X64("x64"),

    /**
     * 32-bit ARM.
     */
    Arm32("arm32"),

    /**
     * 64-bit ARM.
     */
    Arm64("arm64"),

    /**
     * x64 app running on an ARM64 host.
     */
    EmulatedX64("emulated_x64"),

    /**
     * x86 app running on an ARM64 host.
     */
    EmulatedX86("emulated_x86"),

    /**
     * Unknown architecture.
     */
    Unknown("Unknown"),
    ;

    companion object {
        val current: HostArch
            get() = hostArch
    }
}

internal expect val hostArch: HostArch
