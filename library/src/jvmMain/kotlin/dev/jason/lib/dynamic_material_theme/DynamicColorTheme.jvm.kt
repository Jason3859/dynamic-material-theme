package dev.jason.lib.dynamic_material_theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Suppress("unused")
@Composable
actual fun DynamicColorTheme(
    isDarkMode: Boolean,
    defaultPrimary: Long,
    defaultLightScheme: ColorScheme,
    defaultDarkScheme: ColorScheme,
    content: @Composable (() -> Unit)
) {
    val accentColor = getWindowsAccentColorLive()
    val colorScheme = if (accentColor != null) {
        if (isDarkMode)
            ColorSchemes.getDarkScheme(accentColor)
        else
            ColorSchemes.getLightScheme(accentColor)
    } else {
        if (isDarkMode)
            ColorSchemes.getDarkScheme(defaultPrimary)
        else
            ColorSchemes.getLightScheme(defaultPrimary)
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}