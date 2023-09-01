package com.cmdv.domain.uistate.menu

/**
 * TODO
 */
data class MenuUIState(
    val isBluetoothExistent: Boolean = false,
    val isBluetoothEnable: Boolean = false,
    val isControllerConnectedToCar: Boolean = false,
    val isLoading: Boolean = false
)
