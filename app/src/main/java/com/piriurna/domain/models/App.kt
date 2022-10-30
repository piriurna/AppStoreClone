package com.piriurna.domain.models

import com.google.gson.annotations.SerializedName

data class App(
    val id: Int,
    val name: String,
    val added: String?,
    val apkTags: List<String?>?,
    val downloads: Int?,
    val graphic: String?,
    val icon: String?,
    val modified: String?,
    val rating: String?,
    val size: Int?,
    val storeId: Int?,
    val storeName: String?,
    val updated: String?,
    val versionCode: Int?,
    val versionName: String?
){


    companion object {
        val mockApps = listOf(
            App(
                id = 0,
                name = "App 0",
                size = 100,
                added = "123123",
                apkTags = listOf("app", "test", "0"),
                downloads = 1,
                graphic = "https://pool.img.aptoide.com/appupdater/e5a151578bdc332c41c6708e2e680106.png",
                icon = "https://pool.img.aptoide.com/appupdater/df4fd24162f8caec8e487cbb423c29cc_icon.png",
                modified = "123123",
                rating = "4.9",
                storeId = 0,
                storeName = "App Test 0",
                updated = "123123",
                versionCode = 1,
                versionName = "1.0"
            ),
            App(
                id = 1,
                name = "App 1",
                size = 100,
                added = "123123",
                apkTags = listOf("app", "test", "1"),
                downloads = 1,
                graphic = "https://pool.img.aptoide.com/pixl/a2ef54d268050ab5388238267931635d.png",
                icon = "https://pool.img.aptoide.com/pixl/b53365086c49e162fdb442636638cce8_icon.png",
                modified = "123123",
                rating = "3.2",
                storeId = 0,
                storeName = "App Test 1",
                updated = "123123",
                versionCode = 1,
                versionName = "1.0"
            ),
            App(
                id = 2,
                name = "App 2",
                size = 100,
                added = "123123",
                apkTags = listOf("app", "test", "2"),
                downloads = 1,
                graphic = "https://pool.img.aptoide.com/appupdater/06b85cc01963bc0403ba61e08f52384d_fgraphic.jpg",
                icon = "https://pool.img.aptoide.com/appupdater/93e2cb0e9da333f9d9658ddcb4825c22_icon.png",
                modified = "123123",
                rating = "4.2",
                storeId = 0,
                storeName = "App Test 2",
                updated = "123123",
                versionCode = 1,
                versionName = "1.0"
            )
        )
    }
}