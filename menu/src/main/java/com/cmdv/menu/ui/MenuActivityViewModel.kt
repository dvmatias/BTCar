package com.cmdv.menu.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmdv.common.Constants
import com.cmdv.domain.uievent.menu.MenuUIEvent
import com.cmdv.domain.uistate.menu.MenuUIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MenuActivityViewModel : ViewModel() {
    private val _uiState =
        MutableStateFlow(
            MenuUIState(
                isControllerBluetoothModulePresent = false,
                isControllerBluetoothModuleOn = false
            )
        )
    val uiState: StateFlow<MenuUIState> = _uiState

    /**
     * TODO
     */
    fun onEvent(event: MenuUIEvent) {
        Log.d(Constants.TAG_LOG_D, "Event = $event")
        viewModelScope.launch {
            when (event) {
                is MenuUIEvent.Connect -> {
                    // TODO
                }

                is MenuUIEvent.Start -> {
                    // TODO
                }

                else -> Log.d(Constants.TAG_LOG_D, "Event -> not handled")
            }
        }
    }

    private fun canConnect(): Boolean {
        TODO()
    }

    private fun verifyIsControllerBluetoothModulePresent() {

    }

    private fun verifyIsControllerBluetoothModuleOn() {

    }

    private fun verifyIsControllerConnectedToCar() {

    }
}