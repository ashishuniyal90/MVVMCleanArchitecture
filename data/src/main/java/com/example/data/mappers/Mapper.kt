package com.example.data.mappers


interface Mapper<I, O> {
    fun map(input: I): O
}

// Non-nullable to Non-nullable
interface ListMapper<I, O> : Mapper<List<I>, List<O>>

open class ListMapperImpl<I, O>(
    private val mapper: Mapper<I, O>
) : ListMapper<I, O> {
    override fun map(input: List<I>): List<O> {
        return input.map { mapper.map(it) }
    }
}