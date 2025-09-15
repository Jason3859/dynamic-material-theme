package dev.jason.lib.dynamic_material_theme

import com.sun.jna.Library
import com.sun.jna.Native
import com.sun.jna.ptr.IntByReference

internal interface DwmApi : Library {
    @Suppress("FunctionName")
    fun DwmGetColorizationColor(pcrColorization: IntByReference, pfOpaqueBlend: IntByReference): Int
}

internal fun getWindowsAccentColorLive(): Long? {
    return try {
        val dwmApi = Native.load("dwmapi", DwmApi::class.java)
        val colorRef = IntByReference()
        val opaqueRef = IntByReference()
        val result = dwmApi.DwmGetColorizationColor(colorRef, opaqueRef)
        if (result == 0) {
            val argb = colorRef.value.toLong()
            (argb or 0xFF000000)
        } else null
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}
