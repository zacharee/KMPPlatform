package dev.zwander.kmp.platform

import platform.windows.BYTE
import platform.windows.DWORD
import platform.windows.GetVersion
import platform.windows.WORD

private fun WORD.loByte(): BYTE = (this and 0xffU).toUByte()
private fun WORD.hiByte(): BYTE = ((this.toInt() shr 8) and 0xff).toUByte()

private fun DWORD.loWord(): WORD = (this and 0xffffU).toUShort()
private fun DWORD.hiWord(): WORD = ((this.toInt() shr 16) and 0xffff).toUShort()

internal actual val hostOSVersion: OSVersion
    get() {
        val version = GetVersion()

        val majorVersion = version.loWord().loByte()
        val minorVersion = version.loWord().hiByte()

        val build = if (version < 0x80000000U) {
            version.hiWord()
        } else {
            null
        }

        return OSVersion(
            major = majorVersion.toInt(),
            minor = minorVersion.toInt(),
            patch = null,
            build = build?.toLong(),
        )
    }
