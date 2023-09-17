package com.cmdv.btcar.navigation

import android.app.Activity
import android.os.Bundle
import com.cmdv.common.navigator.Navigator

/**
 * Implementation class for [Navigator] contract class.
 *
 * This class holds all the implementations for the navigation functions declared in super class. Each Activity that
 * needs to launch another Activity must use a function declared implemented in this class.
 */
class NavigatorImpl : Navigator {
    override fun toMenu(origin: Activity, bundle: Bundle?, finishPrevious: Boolean) {
      //  origin.navigateTo<MenuActivity>(bundle, finishPrevious)
    }

    override fun toConnectivity(origin: Activity, bundle: Bundle?, finishPrevious: Boolean) {
       // origin.navigateTo<ConnectionActivity>(bundle, finishPrevious)
    }
}