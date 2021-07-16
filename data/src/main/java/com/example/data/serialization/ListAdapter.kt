package com.example.data.serialization

import com.example.data.network.model.UserResponse
import com.squareup.moshi.*


class MoshiUserListAdapter {

    private var listMyData =
        Types.newParameterizedType(MutableList::class.java, UserResponse::class.java)

    private val adapter: JsonAdapter<List<UserResponse>> =
        Moshi.Builder().build().adapter(listMyData)

    @FromJson
    fun fromJson(json: Any) = adapter.fromJsonValue(json)

}