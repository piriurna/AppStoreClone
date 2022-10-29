package com.piriurna.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Responses(
    @SerializedName("listApps")
    val listApps: ListApps
)