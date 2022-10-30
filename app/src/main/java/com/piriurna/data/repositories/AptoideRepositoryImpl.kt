package com.piriurna.data.repositories

import com.piriurna.data.mappers.toApiNetworkError
import com.piriurna.data.mappers.toApp
import com.piriurna.data.remote.ASCException
import com.piriurna.data.remote.sources.AptoideApiSource
import com.piriurna.domain.ApiNetworkResponse
import com.piriurna.domain.models.App
import com.piriurna.domain.repositories.AptoideRepository

class AptoideRepositoryImpl(
    private val aptoideApiSource: AptoideApiSource
) : AptoideRepository {

    override suspend fun getAppList(): ApiNetworkResponse<List<App>> {
        return try {
            ApiNetworkResponse(aptoideApiSource.getAppList().toApp())
        } catch (e : ASCException) {
            ApiNetworkResponse(
                error = e.toApiNetworkError()
            )
        }
    }
}