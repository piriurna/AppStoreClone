package com.piriurna.data.remote.sources

import com.piriurna.data.remote.AptoideApi
import com.piriurna.data.remote.dto.AppListDto

class AptoideApiSource constructor(
    private val aptoideApi: AptoideApi
) {

    suspend fun getAppList() : List<AppListDto> {
        return aptoideApi.getAppList()
    }

}