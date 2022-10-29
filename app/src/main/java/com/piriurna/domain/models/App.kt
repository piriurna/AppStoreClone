package com.piriurna.domain.models

import com.google.gson.annotations.SerializedName

data class App(
    val id: Int,
    val name: String,
    val added: String,
    val apkTags: List<String>,
    val downloads: Int,
    val graphic: String,
    val icon: String,
    val modified: String,
    val rating: Double,
    val size: Int,
    val storeId: Int,
    val storeName: String,
    val updated: String,
    val versionCode: Int,
    val versionName: String
){

}