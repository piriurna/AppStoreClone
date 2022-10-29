package com.piriurna.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Time(
    @SerializedName("human")
    val human: String,
    @SerializedName("seconds")
    val seconds: Double
)