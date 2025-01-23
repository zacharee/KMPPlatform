package dev.zwander.kmp.platform

/**
 * A string identifying the platform on which the user's browser is running; for example:
 * "MacIntel", "Win32", "Linux x86_64", "Linux x86_64".
 * See https://developer.mozilla.org/en-US/docs/Web/API/Navigator/platform - deprecated
 *
 * A string containing the platform brand. For example, "Windows".
 * See https://developer.mozilla.org/en-US/docs/Web/API/NavigatorUAData/platform - new API,
 * but not supported in all browsers
 */
internal fun getNavigatorInfo(): String = js("navigator.userAgentData ? navigator.userAgentData.platform : navigator.platform")

/**
 * In a browser, user platform can be obtained from different places:
 * - we attempt to use not-deprecated but experimental option first (not available in all browsers)
 * - then we attempt to use a deprecated option
 * - if both above return an empty string, we attempt to get `Platform` from `userAgent`
 *
 * Note: a client can spoof these values, so it's okay only for non-critical use cases.
 */
internal fun detectHostOs(): HostOS {
    val platformInfo = getNavigatorInfo().takeIf {
        it.isNotEmpty()
    } ?: js("window.navigator.userAgent")

    return when {
        platformInfo.contains("Android", true) -> HostOS.Android
        platformInfo.contains("iPhone", true) -> HostOS.IOS
        platformInfo.contains("iOS", true) -> HostOS.IOS
        platformInfo.contains("iPad", true) -> HostOS.IOS
        platformInfo.contains("Linux", true) -> HostOS.Linux
        platformInfo.contains("Mac", true) -> HostOS.MacOS
        platformInfo.contains("Win", true) -> HostOS.Windows
        else -> HostOS.Unknown
    }
}

internal actual val hostOS: HostOS
    get() = detectHostOs()
