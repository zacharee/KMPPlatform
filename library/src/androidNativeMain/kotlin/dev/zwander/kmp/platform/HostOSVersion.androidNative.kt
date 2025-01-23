package dev.zwander.kmp.platform

import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.toKStringFromUtf8
import platform.posix.__system_property_get

@OptIn(ExperimentalForeignApi::class)
internal actual val hostOSVersion: OSVersion
    get() = memScoped {
        val releaseString = allocArray<ByteVar>(92)
        val sdkString = allocArray<ByteVar>(92)

        __system_property_get("ro.build.version.release", releaseString)
        __system_property_get("ro.build.version.sdk", sdkString)

        val releaseSplit = releaseString.toKStringFromUtf8().split(".")

        return OSVersion(
            major = releaseSplit.getOrNull(0)?.toIntOrNull(),
            minor = releaseSplit.getOrNull(1)?.toIntOrNull(),
            patch = releaseSplit.getOrNull(2)?.toIntOrNull(),
            build = sdkString.toKStringFromUtf8().toLongOrNull(),
        )
    }
