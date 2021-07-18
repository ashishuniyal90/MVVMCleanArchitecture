package com.example.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * FlowUseCase
 *
 * Base use case to define input and output as wild cards and invoke operator for execution
 * @param Input - variable to use case
 * @return Output
 */

abstract class FlowUseCase<in Params, out Type> where Type : Any {

    abstract suspend fun run(params: Params): Type

    operator fun invoke(params: Params): Flow<Type> {
        return flow {
            val result = run(params)
            emit(result)
        }
    }

}
