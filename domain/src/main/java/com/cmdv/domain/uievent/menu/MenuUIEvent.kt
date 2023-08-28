package com.cmdv.domain.uievent.menu

import com.cmdv.common.UIEvent

/**
 * TODO
 */
sealed class MenuUIEvent : UIEvent {
    /**
     * Ui event triggered when 'Connect' button is clicked
     */
    data object Connect : MenuUIEvent()

    /**
     * Ui event triggered when 'Start' button is clicked
     */
    data object Start : MenuUIEvent()
}