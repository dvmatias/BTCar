package com.cmdv.btcar.domain.usecases

import com.cmdv.btcar.domain.base.BaseUseCase
import com.cmdv.btcar.domain.repositories.BluetoothRepository
import com.cmdv.btcar.domain.utils.ResponseWrapper
import javax.inject.Inject

class ConnectControllerToCarUseCase @Inject constructor(
    private val bluetoothRepository: BluetoothRepository
) : BaseUseCase<ResponseWrapper<Unit>, ConnectControllerToCarUseCase.Params>() {

    override suspend fun executeUseCase(params: Params): ResponseWrapper<Unit> =
        bluetoothRepository.connect(params.carMacAddress)

    /**
     * This request doesn't need params.
     */
    class Params(val carMacAddress: String)
}