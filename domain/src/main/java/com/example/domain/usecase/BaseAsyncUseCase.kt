package com.example.domain.usecase

import com.example.domain.model.Resource

/**
 * BaseAsyncUseCase
 *
 * Base use case to define input and output as wild cards and invoke operator for execution
 * @param Input - variable to use case
 * @return Output
 */
abstract class BaseAsyncUseCase<Input, Output : Any> {

    abstract suspend fun createSuspend(data: Input): Resource<Output>

    suspend operator fun invoke(withData: Input) = createSuspend(withData)
}
