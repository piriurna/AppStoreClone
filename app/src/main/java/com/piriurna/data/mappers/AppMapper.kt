package com.piriurna.data.mappers

import com.piriurna.data.remote.dto.AppDto
import com.piriurna.data.remote.dto.AppListDto
import com.piriurna.domain.models.App

fun AppListDto.toApp() : List<App> {
    return this.responses.listApps.datasets.all.data.list.map {
        it.toApp()
    }
}


fun AppDto.toApp() : App {
    return App(
        id = this.id,
        name = this.name,
        added = this.added,
        apkTags = this.apkTags,
        downloads = this.downloads,
        graphic = this.graphic,
        icon = this.icon,
        modified = this.modified,
        rating = this.rating,
        size = this.size,
        storeId = this.storeId,
        storeName = this.storeName,
        updated = this.updated,
        versionCode = this.vercode,
        versionName = this.vername
    )
}