package com.morface.grandmafia_roleplaying.my_theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.morface.grandmafia_roleplaying.ui.theme.AppTheme

class MainViewModel : ViewModel() {
    var stateApp by mutableStateOf(MainState())

    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.ThemeChange -> {
                stateApp = stateApp.copy(theme = event.theme)
            }
        }
    }

    fun getTheme(event: MainEvent.ThemeChange): AppTheme {
        return event.theme
    }
}

sealed class MainEvent {
    data class ThemeChange(val theme: AppTheme) : MainEvent()
}

data class MainState(
    val theme: AppTheme = AppTheme.LightRed,
)