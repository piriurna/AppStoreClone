package com.piriurna.appstoreclone.di

import com.piriurna.data.remote.sources.AptoideApiSource
import com.piriurna.data.repositories.AptoideRepositoryImpl
import com.piriurna.domain.repositories.AptoideRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    @Singleton
    fun provideAptoideRepository(aptoideApiSource: AptoideApiSource): AptoideRepository {
        return AptoideRepositoryImpl(aptoideApiSource)
    }
}