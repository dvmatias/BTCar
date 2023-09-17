package com.cmdv.btcar.domain.usecases

import com.cmdv.btcar.domain.base.BaseUseCase
import com.cmdv.btcar.domain.models.BluetoothInfoModel
import com.cmdv.btcar.domain.repositories.BluetoothRepository
import com.cmdv.btcar.domain.utils.ResponseWrapper
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