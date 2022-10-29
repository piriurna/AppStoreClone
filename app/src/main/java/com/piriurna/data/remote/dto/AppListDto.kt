package com.piriurna.data.remote.dto


import com.google.gson.annotations.SerializedName

data class AppListDto(
    @SerializedName("responses")
    val responses: Responses,
    @SerializedName("status")
    val status: String
)