package com.cmdv.domain.usecases

import com.cmdv.domain.base.BaseUseCase
import com.cmdv.domain.models.BluetoothInfoModel
import com.cmdv.domain.repositories.BluetoothRepository
import com.cmdv.domain.utils.ResponseWrapper
import javax.inject.Inject

class GetBluetoothAdapterInfoUseCase @Inject constructor(
    private val bluetoothRepository: BluetoothRepository
) : BaseUseCase<ResponseWrapper<BluetoothInfoModel>, GetBluetoothAdapterInfoUseCase.Params>() {

    override suspend fun executeUseCase(params: Params): ResponseWrapper<BluetoothInfoModel> =
        bluetoothRepository.getBluetoothInfo()

    /**
     * This request doesn't need params.
     */
    class Params
}