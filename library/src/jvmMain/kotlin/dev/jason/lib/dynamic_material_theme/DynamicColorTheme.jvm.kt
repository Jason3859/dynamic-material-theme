package dev.jason.lib.dynamic_material_theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb

@Suppress("unused")
@Composable
actual fun DynamicColorTheme(
    isDarkMode: Boolean,
    defaultLightScheme: ColorScheme,
    defaultDarkScheme: ColorScheme,
    content: @Composable (() -> Unit)
) {
    val accentColor = rememberDynamicAccentColor()
    val colorScheme =
        if (isDarkMode) getDarkScheme(accentColor.toArgb().toLong())
        else getLightScheme(accentColor.toArgb().toLong())

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}