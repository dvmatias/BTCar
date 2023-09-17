package com.cmdv.btcar.data.repositories

import com.cmdv.btcar.data.BlueToothDataManager
import com.cmdv.btcar.domain.BluetoothState
import com.cmdv.btcar.domain.models.BluetoothInfoModel
import com.cmdv.btcar.domain.repositories.BluetoothRepository
import com.cmdv.btcar.domain.utils.FailureType
import com.cmdv.btcar.domain.utils.ResponseWrapper
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

    override fun getBluetoothAdapterState(): ResponseWrapper<BluetoothState> {
        // Check BT adapter status
        return when (blueToothDataManager.getBluetoothAdapterState()) {
            BluetoothState.NULL ->
                ResponseWrapper(
                    status = ResponseWrapper.Status.ERROR,
                    failureType = FailureType.BluetoothNonExistent
                )

            BluetoothState.DISABLED ->
                ResponseWrapper(
                    status = ResponseWrapper.Status.ERROR,
                    failureType = FailureType.BluetoothDisable
                )

            BluetoothState.ENABLED ->
                ResponseWrapper(
                    status = ResponseWrapper.Status.READY
                )
        }
    }

    override fun connect(carMacAddress: String): ResponseWrapper<Unit> {
        TODO()
    }
}