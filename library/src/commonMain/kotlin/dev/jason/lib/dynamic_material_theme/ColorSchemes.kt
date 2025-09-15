package dev.jason.lib.dynamic_material_theme

import androidx.compose.material3.ColorScheme

expect fun getLightScheme(seedColor: Long): ColorScheme
expect fun getDarkScheme(seedColor: Long): ColorScheme
