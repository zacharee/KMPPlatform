package dev.zwander.kmp.platform

import dev.zwander.kmp.platform.cinterop.IsWow64Process2
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.UShortVar
import kotlinx.cinterop.cValue
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.pointed
import kotlinx.cinterop.value
import platform.windows.GetCurrentProcess

@OptIn(ExperimentalForeignApi::class)
internal actual val hostArch: HostArch
    get() = memScoped {
        val processHandle = GetCurrentProcess()
        val processMachine = cValue<UShortVar>()
        val nativeMachine = cValue<UShortVar>()

        IsWow64Process2(processHandle, processMachine, nativeMachine)

        return if (nativeMachine.ptr.pointed.value.toInt() == platform.windows.IMAGE_FILE_MACHINE_ARM64) {
            when (processMachine.ptr.pointed.value.toInt()) {
                platform.windows.IMAGE_FILE_MACHINE_AMD64 -> HostArch.EmulatedX64
                platform.windows.IMAGE_FILE_MACHINE_I386 -> HostArch.EmulatedX86
                else -> HostArch.Unknown
            }
        } else {
            HostArch.X64
        }
    }
