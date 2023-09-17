package com.cmdv.btcar.domain.usecases

import com.cmdv.btcar.domain.BluetoothState
import com.cmdv.btcar.domain.base.BaseUseCase
import com.cmdv.btcar.domain.repositories.BluetoothRepository
import com.cmdv.btcar.domain.utils.ResponseWrapper
import javax.inject.Inject

class GetBluetoothStatusUseCase @Inject constructor(
    private val bluetoothRepository: BluetoothRepository
) : BaseUseCase<ResponseWrapper<BluetoothState>, GetBluetoothStatusUseCase.Params>() {

    override suspend fun executeUseCase(params: Params): ResponseWrapper<BluetoothState> =
        bluetoothRepository.getBluetoothAdapterState()

    /**
     * This request doesn't need params.
     */
    class Params(val carMacAddress: String)
}