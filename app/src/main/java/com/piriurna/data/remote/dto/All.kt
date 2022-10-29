package com.piriurna.data.remote.dto


import com.google.gson.annotations.SerializedName

data class All(
    @SerializedName("data")
    val data: Data,
    @SerializedName("info")
    val info: InfoX
)