package com.cmdv.domain.repositories

import com.cmdv.domain.models.BluetoothInfoModel
import com.cmdv.domain.utils.ResponseWrapper

interface BluetoothRepository {
    fun getBluetoothInfo(): ResponseWrapper<BluetoothInfoModel>
}
