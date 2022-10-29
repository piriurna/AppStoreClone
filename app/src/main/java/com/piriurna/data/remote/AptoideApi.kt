package com.piriurna.data.remote

import com.piriurna.data.remote.dto.AppListDto
import retrofit2.http.GET

interface AptoideApi {

    @GET("bulkRequest/api_list/listApps")
    suspend fun getAppList() : List<AppListDto>
}