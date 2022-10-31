package com.piriurna.appstoreclone.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piriurna.domain.Resource
import com.piriurna.domain.models.App
import com.piriurna.domain.usecases.GetAppByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    private val getAppByIdUseCase: GetAppByIdUseCase
) : ViewModel() {


    private val _app = MutableLiveData<App>()
    val app : LiveData<App> = _app


    private val _loading = MutableLiveData<Boolean>()
    val loading : LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String>()
    val error : LiveData<String> = _error

    fun getApp(id : String) {
        _loading.postValue(true)

        viewModelScope.launch {
            getAppByIdUseCase(id).subscribe { result ->
                when(result) {
                    is Resource.Success -> {
                        _app.postValue(result.data!!)
                        _loading.postValue(false)
                    }

                    is Resource.Error -> {
                        _error.postValue(result.message!!)
                        _loading.postValue(false)
                    }
                }
            }
        }
    }
}