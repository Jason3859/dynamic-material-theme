package dev.jason.lib.dynamic_material_theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable

@Composable
expect fun DynamicColorTheme(
    isDarkMode: Boolean = isSystemInDarkTheme(),
    defaultLightScheme: ColorScheme = dev.jason.lib.dynamic_material_theme.defaultLightScheme,
    defaultDarkScheme: ColorScheme = dev.jason.lib.dynamic_material_theme.defaultDarkScheme,
    content: @Composable () -> Unit
)