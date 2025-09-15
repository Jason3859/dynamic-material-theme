package dev.jason.lib.dynamic_material_theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Suppress("unused")
@Composable
actual fun DynamicColorTheme(
    isDarkMode: Boolean,
    defaultPrimary: Long,
    defaultLightScheme: ColorScheme,
    defaultDarkScheme: ColorScheme,
    content: @Composable (() -> Unit)
) {
    val context = LocalContext.current

    val colorScheme = if (isDarkMode) dynamicDarkColorScheme(context) else dynamicDarkColorScheme(context)

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}