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
        rating = if(this.rating == null ||this.rating == 0.0) "---" else this.rating.toString(),
        size = this.size,
        storeId = this.storeId,
        storeName = this.storeName,
        updated = this.updated,
        versionCode = this.vercode,
        versionName = this.vername
    )
}