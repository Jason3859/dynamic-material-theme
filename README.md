## Dynamic color material theme for android and windows

---

### Features

- Dynamic color support for android 12+ and windows
- Light and dark theme support
- Material 3 design principles
- Easy to use and customize

---

### How to use?

- Add the dependency to your `build.gradle` file:

```gradle
implementation 'io.github.jason3859:dynamic-material-theme:1.0.0'
```

or `build.gradle.kts` file:

```kotlin
implementation("io.github.jason3859:dynamic-material-theme:1.0.0")
```

- Use the `DynamicMaterialTheme` composable in your app:

```kotlin
@Composable
fun MyApp() {
    DynamicMaterialTheme { 
        // Your app content
    }
}
```

That's it! You can now enjoy dynamic colors in your app.

---

### Customize `DynamicMaterialTheme` function

```kotlin
@Composable
fun DynamicColorTheme(
    isDarkMode: Boolean = isSystemInDarkTheme(),
    defaultPrimary: Long = 7773407,
    defaultLightScheme: ColorScheme = ColorSchemes.getLightScheme(defaultPrimary),
    defaultDarkScheme: ColorScheme = ColorSchemes.getDarkScheme(defaultPrimary),
    content: @Composable () -> Unit
)
```

- `isDarkMode`: Boolean to indicate if dark mode is enabled. Default is based on system setting.
- `defaultPrimary`: Long value representing the default primary color in case dynamic color is not available. Default is
  `7773407` (a shade of blue). Changing this changes theme only on `windows`. For `android`, you have to override the
  next two params. You can generate your own material
  theme [here](https://material-foundation.github.io/material-theme-builder/).
- `defaultLightScheme`: ColorScheme to use when dynamic color is not available in light mode. Default is generated using
  `defaultPrimary`.
- `defaultDarkScheme`: ColorScheme to use when dynamic color is not available in dark mode. Default is generated using
  `defaultPrimary`.
- `content`: Composable content to be displayed within the theme.

---

### Warning!!

- Dynamic color is only supported on Android 12+ and Windows 11+. On other platforms, the default color scheme will be
  used.
- This only works on `android` and `windows` platforms. On other platforms, the default color scheme will be used.

---

### What to contribute?

You are free to contribute to this library.

#### Get started by cloning

```bash
git clone https://github.com/jason3859/dynamic-material-theme.git
cd dynamic-material-theme
```

---

### Found bugs?

Please report any bugs or issues on the [GitHub Issues](https://github.com/jason3859/dynamic-material-theme/issues)
page.

---