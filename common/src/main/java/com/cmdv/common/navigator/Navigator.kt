package com.cmdv.common.navigator

import android.app.Activity
import android.os.Bundle
import com.cmdv.common.Event

/**
 * Contract. Declares all the functions to navigate between activities from different modules/features.
 */
interface Navigator {
    fun toMenu(origin: Activity, bundle: Bundle? = null, finishPrevious: Boolean = false)
    fun toConnectivity(origin: Activity, bundle: Bundle? = null, finishPrevious: Boolean = false)
}