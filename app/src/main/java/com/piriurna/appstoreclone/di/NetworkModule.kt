package com.piriurna.appstoreclone.di

import com.piriurna.appstoreclone.BuildConfig
import com.piriurna.data.remote.AptoideApi
import com.piriurna.data.remote.sources.AptoideApiSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideHttpClient() : OkHttpClient {

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)


        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .readTimeout(BuildConfig.READ_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(BuildConfig.CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun provideAptoideApi(okHttpClient: OkHttpClient): AptoideApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AptoideApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAptoideApiSource(aptoideApi: AptoideApi): AptoideApiSource {
        return AptoideApiSource(aptoideApi)
    }
}