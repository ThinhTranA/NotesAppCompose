package com.example.notesappcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

private val LightThemeColors = lightColors(
    primary = mGreen,
    primaryVariant = mGreenDark,
    secondary = mRed
)

private val DarkThemeColors = lightColors(
    primary = Color(0xFF00A055),
    primaryVariant = Color(0xFF00F884),
    secondary = mRed,
    onPrimary = Color.White
)

/**
 * Responsible for switching color palette for dark and light theme.
 */
@Composable
fun NotesAppComposeTheme(content: @Composable () -> Unit) {
    val isDarkThemeEnabled = isSystemInDarkTheme() || JetNotesThemeSettings.isDarkThemeEnabled
    val colors = if (isDarkThemeEnabled) DarkThemeColors else LightThemeColors

    MaterialTheme(colors = colors, content = content)
}

/**
 * Allows changing between light and a dark theme from the app's settings.
 */
object JetNotesThemeSettings {
    var isDarkThemeEnabled by mutableStateOf(false)
}