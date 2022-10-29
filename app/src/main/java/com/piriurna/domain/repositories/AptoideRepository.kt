package com.piriurna.domain.repositories

import com.piriurna.domain.ApiNetworkResponse
import com.piriurna.domain.models.App

interface AptoideRepository {

    suspend fun getAppList() : ApiNetworkResponse<List<App>>
}