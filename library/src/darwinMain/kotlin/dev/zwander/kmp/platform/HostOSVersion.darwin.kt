package dev.zwander.kmp.platform

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.UnsafeNumber
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.pointed
import platform.Foundation.NSProcessInfo

@OptIn(ExperimentalForeignApi::class, UnsafeNumber::class)
internal actual val hostOSVersion: OSVersion
    get() = memScoped {
        val osVersion = NSProcessInfo.processInfo.operatingSystemVersion.ptr.pointed

        return OSVersion(
            major = osVersion.majorVersion,
            minor = osVersion.minorVersion,
            patch = osVersion.patchVersion,
            build = null,
        )
    }
