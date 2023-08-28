package com.cmdv.domain.uistate.menu

/**
 * TODO
 */
data class MenuUIState(
    val isControllerBluetoothModulePresent: Boolean,
    val isControllerBluetoothModuleOn: Boolean,
    val isControllerConnectedToCar: Boolean = false,
    val isLoading: Boolean = false
)
