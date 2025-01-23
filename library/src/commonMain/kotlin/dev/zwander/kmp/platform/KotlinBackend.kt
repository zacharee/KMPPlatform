package dev.zwander.kmp.platform

enum class KotlinBackend(val id: String) {
    JVM("jvm"),
    JS("js"),
    Native("native"),
    Wasm("wasm"),
    ;

    companion object {
        val current: KotlinBackend
            get() = hostBackend
    }
}

internal expect val hostBackend: KotlinBackend
