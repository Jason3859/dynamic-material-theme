package dev.jason.lib.dynamic_material_theme

import androidx.compose.material3.ColorScheme

actual fun getLightScheme(seedColor: Long): ColorScheme {
    return lightScheme
}

actual fun getDarkScheme(seedColor: Long): ColorScheme {
    return darkScheme
}