package dev.zwander.kmp.platform

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.alloc
import kotlinx.cinterop.cValue
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.pointed
import kotlinx.cinterop.toKString
import platform.posix.uname
import platform.posix.utsname

@OptIn(ExperimentalForeignApi::class)
internal actual val hostOSVersion: OSVersion
    get() = memScoped {
        val unameValue = cValue<utsname>()

        return if (uname(unameValue) != -1) {
            val releaseString = unameValue.ptr.pointed.release.toKString()
            val versionAndBuild = releaseString.split("-")

            val majorMinorAndPatch = versionAndBuild.firstOrNull()?.split(".")
            val major = majorMinorAndPatch?.getOrNull(0)
            val minor = majorMinorAndPatch?.getOrNull(1)
            val patch = majorMinorAndPatch?.getOrNull(2)

            val build = versionAndBuild.getOrNull(1)

            OSVersion(
                major = major?.toIntOrNull(),
                minor = minor?.toIntOrNull(),
                patch = patch?.toIntOrNull(),
                build = build?.toLongOrNull(),
            )
        } else {
            OSVersion.Unknown
        }
    }
