package com.cmdv.btcar.domain.uievent

/**
 * TODO
 */
sealed class UiEvent {
    data object Connect : UiEvent()
    data object AskUserEnableBluetooth : UiEvent()
}