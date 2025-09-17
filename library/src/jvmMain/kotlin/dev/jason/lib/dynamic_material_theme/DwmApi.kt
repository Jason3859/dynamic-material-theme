package dev.jason.lib.dynamic_material_theme

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.sun.jna.Library
import com.sun.jna.Native
import com.sun.jna.ptr.IntByReference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.swing.Swing
import kotlinx.coroutines.withContext

internal interface DwmApi : Library {
    @Suppress("FunctionName")
    fun DwmGetColorizationColor(colorizationColor: IntByReference, opaqueBlend: IntByReference): Int
}

private val dwmApi: DwmApi = Native.load("dwmapi", DwmApi::class.java)

internal fun getWindowsAccentColor(): Int {
    val colorRef = IntByReference()
    val opaqueRef = IntByReference()
    val result = dwmApi.DwmGetColorizationColor(colorRef, opaqueRef)
    if (result == 0) {
        return colorRef.value
    }
    return 0xFF3CB28D.toInt()
}

internal fun Int.toComposeColor(): Color {
    val a = (this shr 24) and 0xFF
    val r = (this shr 16) and 0xFF
    val g = (this shr 8) and 0xFF
    val b = this and 0xFF
    return Color(r, g, b, a)
}

@Composable
fun rememberDynamicAccentColor(pollIntervalMs: Long = 1000L): Color {
    var color by remember { mutableStateOf(getWindowsAccentColor().toComposeColor()) }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.Swing) {
            var lastColor = getWindowsAccentColor()
            while (true) {
                delay(pollIntervalMs)
                val newColor = getWindowsAccentColor()
                if (newColor != lastColor) {
                    lastColor = newColor
                    withContext(Dispatchers.Main) {
                        color = newColor.toComposeColor()
                    }
                }
            }
        }
    }
    return color
}
