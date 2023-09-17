package com.cmdv.btcar.domain.uistate

/**
 * TODO
 */
data class MenuUIState(
    val isBluetoothExistent: Boolean = false,
    val isBluetoothEnable: Boolean = false,
    val isControllerConnectedToCar: Boolean = false,
    val isLoading: Boolean = false
)
