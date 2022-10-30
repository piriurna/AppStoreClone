package com.piriurna.domain.usecases

import BaseUseCaseTest
import com.piriurna.domain.ApiNetworkError
import com.piriurna.domain.ApiNetworkResponse
import com.piriurna.domain.Resource
import com.piriurna.domain.models.App
import com.piriurna.domain.repositories.AptoideRepository
import com.piriurna.domain.usecases.GetEditorsChoiceAppListUseCase.Companion.NO_APPS_FOUND
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.whenever

class GetLocalTopAppsListUseCaseTest : BaseUseCaseTest() {

    private lateinit var getLocalTopAppsListUseCase: GetLocalTopAppsListUseCase
    private lateinit var aptoideRepository: AptoideRepository

    @Before
    fun setUp() {
        aptoideRepository = mock()
        getLocalTopAppsListUseCase = GetLocalTopAppsListUseCase(aptoideRepository = aptoideRepository)
    }


    private val data = listOf(
        App( // SHOULD SHOW IN EDITORS CHOICE
            id = 0,
            name = "App 0",
            size = 100,
            added = "123123",
            apkTags = listOf("app", "test", "0"),
            downloads = 1,
            graphic = "https://pool.img.aptoide.com/appupdater/e5a151578bdc332c41c6708e2e680106.png",
            icon = "https://pool.img.aptoide.com/appupdater/df4fd24162f8caec8e487cbb423c29cc_icon.png",
            modified = "123123",
            rating = "4.0",
            storeId = 0,
            storeName = "App Test 0",
            updated = "123123",
            versionCode = 1,
            versionName = "1.0"
        ),
        App( // SHOULD NOT SHOW IN EDITORS CHOICE
            id = 1,
            name = "App 1",
            size = 100,
            added = "123123",
            apkTags = listOf("app", "test", "1"),
            downloads = 1,
            graphic = "",
            icon = "https://pool.img.aptoide.com/pixl/b53365086c49e162fdb442636638cce8_icon.png",
            modified = "123123",
            rating = "3.2",
            storeId = 0,
            storeName = "App Test 1",
            updated = "123123",
            versionCode = 1,
            versionName = "1.0"
        ),
        App( // SHOULD SHOW IN EDITORS CHOICE
            id = 2,
            name = "App 2",
            size = 100,
            added = "123123",
            apkTags = listOf("app", "test", "2"),
            downloads = 1,
            graphic = "https://pool.img.aptoide.com/appupdater/06b85cc01963bc0403ba61e08f52384d_fgraphic.jpg",
            icon = "https://pool.img.aptoide.com/appupdater/93e2cb0e9da333f9d9658ddcb4825c22_icon.png",
            modified = "123123",
            rating = "4.2",
            storeId = 0,
            storeName = "App Test 2",
            updated = "123123",
            versionCode = 1,
            versionName = "1.0"
        )
    )

    @ExperimentalCoroutinesApi
    @Test
    fun `ask for data and receive data`() = runTest {
        whenever(aptoideRepository.getAppList()).thenReturn(
            ApiNetworkResponse(data)
        )

        getLocalTopAppsListUseCase()
            .test()
            .assertNoErrors()
            .assertValue {
                return@assertValue it is Resource.Success
            }

    }

    @ExperimentalCoroutinesApi
    @Test
    fun `ask for data and receive error`() = runTest {
        whenever(aptoideRepository.getAppList()).thenReturn(
            ApiNetworkResponse(error = ApiNetworkError(400))
        )

        getLocalTopAppsListUseCase()
            .test()
            .assertValue {
                return@assertValue it is Resource.Error
            }

    }

}