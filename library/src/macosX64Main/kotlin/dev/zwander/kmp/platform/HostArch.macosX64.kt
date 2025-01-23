package dev.zwander.kmp.platform

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.IntVar
import kotlinx.cinterop.cValue
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.sizeOf
import kotlinx.cinterop.toCPointer
import platform.darwin.sysctlbyname

@OptIn(ExperimentalForeignApi::class)
internal actual val hostArch: HostArch
    get() = memScoped {
        val ret = cValue<IntVar>()

        return if (sysctlbyname("sysctl.proc_translated", ret, sizeOf<IntVar>().toCPointer(), null, 0U) != -1) {
            HostArch.EmulatedX64
        } else {
            HostArch.X64
        }
    }
