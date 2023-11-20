package com.morface.grandmafia_roleplaying.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable


private val LightColors = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
    onPrimaryContainer = md_theme_light_onPrimaryContainer,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    secondaryContainer = md_theme_light_secondaryContainer,
    onSecondaryContainer = md_theme_light_onSecondaryContainer,
    tertiary = md_theme_light_tertiary,
    onTertiary = md_theme_light_onTertiary,
    tertiaryContainer = md_theme_light_tertiaryContainer,
    onTertiaryContainer = md_theme_light_onTertiaryContainer,
    error = md_theme_light_error,
    errorContainer = md_theme_light_errorContainer,
    onError = md_theme_light_onError,
    onErrorContainer = md_theme_light_onErrorContainer,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurfaceVariant = md_theme_light_onSurfaceVariant,
    outline = md_theme_light_outline,
    inverseOnSurface = md_theme_light_inverseOnSurface,
    inverseSurface = md_theme_light_inverseSurface,
    inversePrimary = md_theme_light_inversePrimary,
    surfaceTint = md_theme_light_surfaceTint,
    outlineVariant = md_theme_light_outlineVariant,
    scrim = md_theme_light_scrim,
)


private val DarkColors = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    tertiary = md_theme_dark_tertiary,
    onTertiary = md_theme_dark_onTertiary,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    error = md_theme_dark_error,
    errorContainer = md_theme_dark_errorContainer,
    onError = md_theme_dark_onError,
    onErrorContainer = md_theme_dark_onErrorContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    outline = md_theme_dark_outline,
    inverseOnSurface = md_theme_dark_inverseOnSurface,
    inverseSurface = md_theme_dark_inverseSurface,
    inversePrimary = md_theme_dark_inversePrimary,
    surfaceTint = md_theme_dark_surfaceTint,
    outlineVariant = md_theme_dark_outlineVariant,
    scrim = md_theme_dark_scrim,
)

private val LightGreenColors = lightColorScheme(
    primary = md_theme_light_green_primary,
    onPrimary = md_theme_light_green_onPrimary,
    primaryContainer = md_theme_light_green_primaryContainer,
    onPrimaryContainer = md_theme_light_green_onPrimaryContainer,
    secondary = md_theme_light_green_secondary,
    onSecondary = md_theme_light_green_onSecondary,
    secondaryContainer = md_theme_light_green_secondaryContainer,
    onSecondaryContainer = md_theme_light_green_onSecondaryContainer,
    tertiary = md_theme_light_green_tertiary,
    onTertiary = md_theme_light_green_onTertiary,
    tertiaryContainer = md_theme_light_green_tertiaryContainer,
    onTertiaryContainer = md_theme_light_green_onTertiaryContainer,
    error = md_theme_light_green_error,
    errorContainer = md_theme_light_green_errorContainer,
    onError = md_theme_light_green_onError,
    onErrorContainer = md_theme_light_green_onErrorContainer,
    background = md_theme_light_green_background,
    onBackground = md_theme_light_green_onBackground,
    surface = md_theme_light_green_surface,
    onSurface = md_theme_light_green_onSurface,
    surfaceVariant = md_theme_light_green_surfaceVariant,
    onSurfaceVariant = md_theme_light_green_onSurfaceVariant,
    outline = md_theme_light_green_outline,
    inverseOnSurface = md_theme_light_green_inverseOnSurface,
    inverseSurface = md_theme_light_green_inverseSurface,
    inversePrimary = md_theme_light_green_inversePrimary,
    surfaceTint = md_theme_light_green_surfaceTint,
    outlineVariant = md_theme_light_green_outlineVariant,
    scrim = md_theme_light_green_scrim,
)

private val DarkGreenColors = darkColorScheme(
    primary = md_theme_dark_green_primary,
    onPrimary = md_theme_dark_green_onPrimary,
    primaryContainer = md_theme_dark_green_primaryContainer,
    onPrimaryContainer = md_theme_dark_green_onPrimaryContainer,
    secondary = md_theme_dark_green_secondary,
    onSecondary = md_theme_dark_green_onSecondary,
    secondaryContainer = md_theme_dark_green_secondaryContainer,
    onSecondaryContainer = md_theme_dark_green_onSecondaryContainer,
    tertiary = md_theme_dark_green_tertiary,
    onTertiary = md_theme_dark_green_onTertiary,
    tertiaryContainer = md_theme_dark_green_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_green_onTertiaryContainer,
    error = md_theme_dark_green_error,
    errorContainer = md_theme_dark_green_errorContainer,
    onError = md_theme_dark_green_onError,
    onErrorContainer = md_theme_dark_green_onErrorContainer,
    background = md_theme_dark_green_background,
    onBackground = md_theme_dark_green_onBackground,
    surface = md_theme_dark_green_surface,
    onSurface = md_theme_dark_green_onSurface,
    surfaceVariant = md_theme_dark_green_surfaceVariant,
    onSurfaceVariant = md_theme_dark_green_onSurfaceVariant,
    outline = md_theme_dark_green_outline,
    inverseOnSurface = md_theme_dark_green_inverseOnSurface,
    inverseSurface = md_theme_dark_green_inverseSurface,
    inversePrimary = md_theme_dark_green_inversePrimary,
    surfaceTint = md_theme_dark_green_surfaceTint,
    outlineVariant = md_theme_dark_green_outlineVariant,
    scrim = md_theme_dark_green_scrim,
)

private val LightRedColors = lightColorScheme(
    primary = md_theme_light_red_primary,
    onPrimary = md_theme_light_red_onPrimary,
    primaryContainer = md_theme_light_red_primaryContainer,
    onPrimaryContainer = md_theme_light_red_onPrimaryContainer,
    secondary = md_theme_light_red_secondary,
    onSecondary = md_theme_light_red_onSecondary,
    secondaryContainer = md_theme_light_red_secondaryContainer,
    onSecondaryContainer = md_theme_light_red_onSecondaryContainer,
    tertiary = md_theme_light_red_tertiary,
    onTertiary = md_theme_light_red_onTertiary,
    tertiaryContainer = md_theme_light_red_tertiaryContainer,
    onTertiaryContainer = md_theme_light_red_onTertiaryContainer,
    error = md_theme_light_red_error,
    errorContainer = md_theme_light_red_errorContainer,
    onError = md_theme_light_red_onError,
    onErrorContainer = md_theme_light_red_onErrorContainer,
    background = md_theme_light_red_background,
    onBackground = md_theme_light_red_onBackground,
    surface = md_theme_light_red_surface,
    onSurface = md_theme_light_red_onSurface,
    surfaceVariant = md_theme_light_red_surfaceVariant,
    onSurfaceVariant = md_theme_light_red_onSurfaceVariant,
    outline = md_theme_light_red_outline,
    inverseOnSurface = md_theme_light_red_inverseOnSurface,
    inverseSurface = md_theme_light_red_inverseSurface,
    inversePrimary = md_theme_light_red_inversePrimary,
    surfaceTint = md_theme_light_red_surfaceTint,
    outlineVariant = md_theme_light_red_outlineVariant,
    scrim = md_theme_light_red_scrim,
)

private val DarkRedColors = darkColorScheme(
    primary = md_theme_dark_red_primary,
    onPrimary = md_theme_dark_red_onPrimary,
    primaryContainer = md_theme_dark_red_primaryContainer,
    onPrimaryContainer = md_theme_dark_red_onPrimaryContainer,
    secondary = md_theme_dark_red_secondary,
    onSecondary = md_theme_dark_red_onSecondary,
    secondaryContainer = md_theme_dark_red_secondaryContainer,
    onSecondaryContainer = md_theme_dark_red_onSecondaryContainer,
    tertiary = md_theme_dark_red_tertiary,
    onTertiary = md_theme_dark_red_onTertiary,
    tertiaryContainer = md_theme_dark_red_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_red_onTertiaryContainer,
    error = md_theme_dark_red_error,
    errorContainer = md_theme_dark_red_errorContainer,
    onError = md_theme_dark_red_onError,
    onErrorContainer = md_theme_dark_red_onErrorContainer,
    background = md_theme_dark_red_background,
    onBackground = md_theme_dark_red_onBackground,
    surface = md_theme_dark_red_surface,
    onSurface = md_theme_dark_red_onSurface,
    surfaceVariant = md_theme_dark_red_surfaceVariant,
    onSurfaceVariant = md_theme_dark_red_onSurfaceVariant,
    outline = md_theme_dark_red_outline,
    inverseOnSurface = md_theme_dark_red_inverseOnSurface,
    inverseSurface = md_theme_dark_red_inverseSurface,
    inversePrimary = md_theme_dark_red_inversePrimary,
    surfaceTint = md_theme_dark_red_surfaceTint,
    outlineVariant = md_theme_dark_red_outlineVariant,
    scrim = md_theme_dark_red_scrim,
)

enum class AppTheme {
    Light, Dark, Default, DarkGreen, LightGreen, DarkRed, LightRed
}

@Composable
fun GrandRolePlayingTheme(
    appTheme: AppTheme,
    isDarkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when (appTheme) {
        AppTheme.Default -> {
            if (isDarkMode) {
                DarkColors
            } else {
                LightColors
            }
        }

        AppTheme.Light -> LightColors
        AppTheme.Dark -> DarkColors
        AppTheme.LightGreen -> LightGreenColors
        AppTheme.DarkGreen -> DarkGreenColors
        AppTheme.DarkRed -> DarkRedColors
        AppTheme.LightRed -> LightRedColors

    }

//    val systemUiController = rememberSystemUiController()
//    SideEffect {
//        systemUiController.setStatusBarColor(
//            color = colorScheme.primary,
//            darkIcons = false,
//        )
//    }
    MaterialTheme(
        colorScheme = colorScheme, typography = Typography, content = content
    )
}
