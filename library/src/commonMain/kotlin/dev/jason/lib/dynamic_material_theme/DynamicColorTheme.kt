package dev.jason.lib.dynamic_material_theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable

@Composable
expect fun DynamicColorTheme(
    isDarkMode: Boolean = isSystemInDarkTheme(),
    defaultPrimary: Long = 7773407,
    defaultLightScheme: ColorScheme = getLightScheme(defaultPrimary),
    defaultDarkScheme: ColorScheme = getDarkScheme(defaultPrimary),
    content: @Composable () -> Unit
)