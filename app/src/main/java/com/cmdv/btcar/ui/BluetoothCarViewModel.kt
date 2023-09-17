package com.cmdv.btcar.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmdv.btcar.domain.uievent.UiEvent
import com.cmdv.btcar.domain.uistate.MenuUIState
import com.cmdv.btcar.domain.usecases.ConnectControllerToCarUseCase
import com.cmdv.btcar.domain.usecases.GetBluetoothStatusUseCase
import com.cmdv.btcar.domain.utils.FailureType
import com.cmdv.btcar.domain.utils.ResponseWrapper
import com.cmdv.common.Constants
import com.cmdv.common.Constants.TAG_LOG_D
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BluetoothCarViewModel @Inject constructor(
    private val getBluetoothStatusUseCase: GetBluetoothStatusUseCase,
    private val connectControllerToCarUseCase: ConnectControllerToCarUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(MenuUIState())
    val uiState: StateFlow<MenuUIState> = _uiState

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent: SharedFlow<UiEvent> = _uiEvent

    /**
     * TODO
     */
    fun handleUiEvent(event: UiEvent) {
        Log.d(TAG_LOG_D, "Event = $event")
        viewModelScope.launch {
            _uiEvent.emit(event)
        }
    }

    fun startConnectionProcess() {
        viewModelScope.launch {
            getBluetoothStatusUseCase.executeUseCase(GetBluetoothStatusUseCase.Params(""))
                .let { response ->
                    when (response.status) {
                        ResponseWrapper.Status.READY -> connect()
                        else -> {
                            if (response.failureType == FailureType.BluetoothDisable)
                                handleUiEvent(UiEvent.AskUserEnableBluetooth)
                        }
                    }
                }
        }
    }

    private fun connect() {
        Log.d(TAG_LOG_D, "Connect")
    }
}