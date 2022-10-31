package com.piriurna.data.remote.dto


import com.google.gson.annotations.SerializedName

data class AppDto(
    @SerializedName("added")
    val added: String?,
    @SerializedName("apk_tags")
    val apkTags: List<String?>?,
    @SerializedName("downloads")
    val downloads: Long?,
    @SerializedName("graphic")
    val graphic: String?,
    @SerializedName("icon")
    val icon: String?,
    @SerializedName("id")
    val id: Long,
    @SerializedName("md5sum")
    val md5sum: String?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("package")
    val packageX: String?,
    @SerializedName("pdownloads")
    val pdownloads: Long?,
    @SerializedName("rating")
    val rating: Double?,
    @SerializedName("size")
    val size: Long?,
    @SerializedName("store_id")
    val storeId: Long?,
    @SerializedName("store_name")
    val storeName: String?,
    @SerializedName("updated")
    val updated: String?,
    @SerializedName("uptype")
    val uptype: String?,
    @SerializedName("vercode")
    val vercode: Long?,
    @SerializedName("vername")
    val vername: String?
)