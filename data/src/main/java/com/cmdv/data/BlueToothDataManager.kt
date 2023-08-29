package com.cmdv.data

import android.bluetooth.BluetoothManager
import android.content.Context
import javax.inject.Inject

class BlueToothDataManager @Inject constructor(
    private val context: Context
) {
    private val bluetoothManager by lazy {
        context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
    }
    val bluetoothAdapter by lazy {
        bluetoothManager.adapter
    }
}