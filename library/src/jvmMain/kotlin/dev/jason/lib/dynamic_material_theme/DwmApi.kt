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

        if (!System.getProperty("os.name").contains("windows", true)) null

        val dwmApi = Native.load("dwmapi", DwmApi::class.java)
        val colorRef = IntByReference()
        val opaqueRef = IntByReference()
        val result = dwmApi.DwmGetColorizationColor(colorRef, opaqueRef)
        if (result == 0) {
            val abgr = colorRef.value.toLong()
            val a = (abgr shr 24) and 0xFF
            val b = (abgr shr 16) and 0xFF
            val g = (abgr shr 8) and 0xFF
            val r = abgr and 0xFF
            (a shl 24 or (r shl 16) or (g shl 8) or b)
        } else null
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}
