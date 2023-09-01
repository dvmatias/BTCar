package com.cmdv.menu.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmdv.common.Constants
import com.cmdv.domain.uievent.menu.MenuUIEvent
import com.cmdv.domain.uistate.menu.MenuUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuActivityViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(MenuUIState())
    val uiState: StateFlow<MenuUIState> = _uiState

    private val _event = MutableSharedFlow<MenuUIEvent>()
    val event: SharedFlow<MenuUIEvent> = _event

    /**
     * TODO
     */
    fun onEvent(event: MenuUIEvent) {
        Log.d(Constants.TAG_LOG_D, "Event = $event")
        viewModelScope.launch {
            _event.emit(event)
        }
    }
}