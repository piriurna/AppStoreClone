package com.piriurna.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Datasets(
    @SerializedName("all")
    val all: All
)