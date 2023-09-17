package com.cmdv.btcar.data

import android.app.Activity.RESULT_OK
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import com.cmdv.btcar.domain.BluetoothState
import javax.inject.Inject

class BlueToothDataManager @Inject constructor(
    private val context: Context
) {
    private val bluetoothManager by lazy {
        context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
    }

    val bluetoothAdapter: BluetoothAdapter? by lazy {
        bluetoothManager.adapter
    }

    fun getBluetoothAdapterState(): BluetoothState =
        bluetoothAdapter?.let {
            if (it.isEnabled) BluetoothState.ENABLED else BluetoothState.DISABLED
        } ?: kotlin.run { BluetoothState.NULL }

}