package com.piriurna.data.remote.sources

import com.piriurna.data.remote.AptoideApi
import com.piriurna.data.remote.dto.AppListDto
import javax.inject.Inject

class AptoideApiSource @Inject constructor(
    private val aptoideApi: AptoideApi
) {

    suspend fun getAppList() : AppListDto {
        return aptoideApi.getAppList()
    }

}