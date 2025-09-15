package dev.jason.lib.dynamic_material_theme

import android.os.Build
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

    val colorScheme = when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (isDarkMode) dynamicDarkColorScheme(context) else dynamicDarkColorScheme(context)
        }

        isDarkMode -> defaultDarkScheme
        else -> defaultLightScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}