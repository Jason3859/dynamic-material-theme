package dev.jason.lib.dynamic_material_theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Suppress("unused")
@Composable
actual fun DynamicColorTheme(
    isDarkMode: Boolean,
    defaultLightScheme: ColorScheme,
    defaultDarkScheme: ColorScheme,
    content: @Composable (() -> Unit)
) {
    val accentColor = getWindowsAccentColorLive()
    val colorScheme = if (accentColor != null) {
        if (isDarkMode)
            getDarkScheme(accentColor)
        else
            getLightScheme(accentColor)
    } else {
        if (isDarkMode)
            defaultDarkScheme
        else
            defaultLightScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}