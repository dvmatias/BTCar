package com.cmdv.menu.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmdv.common.Constants
import com.cmdv.domain.uievent.menu.MenuUIEvent
import com.cmdv.domain.uistate.menu.MenuUIState
import com.cmdv.domain.usecases.GetBluetoothAdapterInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuActivityViewModel @Inject constructor(
    private val getBluetoothAdapterInfoUseCase: GetBluetoothAdapterInfoUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(
        MenuUIState(
            isControllerBluetoothModulePresent = false, isControllerBluetoothModuleOn = false
        )
    )
    val uiState: StateFlow<MenuUIState> = _uiState

    /**
     * TODO
     */
    fun onEvent(event: MenuUIEvent) {
        Log.d(Constants.TAG_LOG_D, "Event = $event")
        when (event) {
            is MenuUIEvent.Connect -> {
                // TODO
                getBluetoothAdapterInfo()
            }

            is MenuUIEvent.Start -> {
                // TODO
            }

            else -> Log.d(Constants.TAG_LOG_D, "Event -> not handled")
        }
    }

    private fun getBluetoothAdapterInfo() {
        viewModelScope.launch {
            getBluetoothAdapterInfoUseCase(GetBluetoothAdapterInfoUseCase.Params())
                .collect { responseWrapper ->
                    Log.d(Constants.TAG_LOG_D, "data -> ${responseWrapper.data}")
                }
        }
    }

    private fun canConnect(): Boolean {
        TODO()
    }

    private fun verifyIsControllerBluetoothModulePresent() {

    }
}