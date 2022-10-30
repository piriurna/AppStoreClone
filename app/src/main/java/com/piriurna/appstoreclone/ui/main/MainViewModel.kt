package com.piriurna.appstoreclone.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piriurna.domain.Resource
import com.piriurna.domain.models.App
import com.piriurna.domain.usecases.GetAppListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAppListUseCase: GetAppListUseCase
): ViewModel() {


    private val _appList = MutableLiveData<List<App>>()
    val appList : LiveData<List<App>> = _appList

    private val _loading = MutableLiveData<Boolean>()
    val loading : LiveData<Boolean> = _loading


    private val _error = MutableLiveData<String>()
    val error : LiveData<String> = _error

    fun getAppList() {
        _loading.postValue(true)
        viewModelScope.launch {
            getAppListUseCase().subscribe { result ->
                when(result) {
                    is Resource.Success -> {
                        _appList.postValue(result.data!!)
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