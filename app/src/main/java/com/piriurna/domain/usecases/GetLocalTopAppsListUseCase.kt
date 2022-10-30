package com.piriurna.domain.usecases

import com.piriurna.domain.ApiNetworkResponse
import com.piriurna.domain.Resource
import com.piriurna.domain.models.App
import com.piriurna.domain.repositories.AptoideRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GetLocalTopAppsListUseCase @Inject constructor(
    private val aptoideRepository: AptoideRepository
){

    suspend operator fun invoke() : Observable<Resource<List<App>>>{
        val appList = aptoideRepository.getAppList()

        return Observable.create{

            appList.data?.let { list ->
                val localTopApps = list.filter { it.rating?.toDoubleOrNull() == null || it.graphic.isNullOrEmpty() }
                it.onNext(Resource.Success(localTopApps))
            }?: run {
                it.onNext(Resource.Error(appList.error.message?:NO_APPS_FOUND))
            }
        }
    }

    companion object {
        const val NO_APPS_FOUND = "No Apps Found"
    }
}