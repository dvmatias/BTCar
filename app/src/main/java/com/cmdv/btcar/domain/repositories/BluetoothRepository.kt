package com.cmdv.btcar.domain.repositories

import com.cmdv.btcar.domain.BluetoothState
import com.cmdv.btcar.domain.models.BluetoothInfoModel
import com.cmdv.btcar.domain.utils.ResponseWrapper

interface BluetoothRepository {
    fun getBluetoothInfo(): ResponseWrapper<BluetoothInfoModel>
    fun getBluetoothAdapterState(): ResponseWrapper<BluetoothState>
    fun connect(carMacAddress: String): ResponseWrapper<Unit>
}
