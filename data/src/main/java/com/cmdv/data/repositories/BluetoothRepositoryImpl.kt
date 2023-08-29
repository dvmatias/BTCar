package com.cmdv.data.repositories

import com.cmdv.data.BlueToothDataManager
import com.cmdv.domain.models.BluetoothInfoModel
import com.cmdv.domain.repositories.BluetoothRepository
import com.cmdv.domain.utils.ResponseWrapper
import javax.inject.Inject

class BluetoothRepositoryImpl @Inject constructor(
    private val blueToothDataManager: BlueToothDataManager
) : BluetoothRepository {
    override fun getBluetoothInfo(): ResponseWrapper<BluetoothInfoModel> {
        return ResponseWrapper(
            data = BluetoothInfoModel(
                bluetoothAdapter = blueToothDataManager.bluetoothAdapter
            )
        )
    }
}