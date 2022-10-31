package com.piriurna.domain.usecases

import com.piriurna.domain.Resource
import com.piriurna.domain.models.App
import com.piriurna.domain.repositories.AptoideRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GetAppByIdUseCase @Inject constructor(
    private val aptoideRepository: AptoideRepository
){

    suspend operator fun invoke(id : String) : Observable<Resource<App>>{
        val appList =  aptoideRepository.getAppList()

        return Observable.create{

            appList.data?.let { list ->
                val appById = list.firstOrNull { it.id.toString() == id }

                appById?.let { app ->
                    it.onNext(Resource.Success(app))
                }?: kotlin.run {
                    it.onNext(Resource.Error(NO_APPS_FOUND))
                }
            }?: run {
                it.onNext(Resource.Error(appList.error.message?:NO_APPS_FOUND))
            }
        }
    }


    companion object {
        const val NO_APPS_FOUND = "No Apps Found"
    }
}