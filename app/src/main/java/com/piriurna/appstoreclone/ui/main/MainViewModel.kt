package com.piriurna.appstoreclone.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piriurna.domain.Resource
import com.piriurna.domain.models.App
import com.piriurna.domain.usecases.GetEditorsChoiceAppListUseCase
import com.piriurna.domain.usecases.GetLocalTopAppsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getLocalTopAppsListUseCase: GetLocalTopAppsListUseCase,
    private val getEditorsChoiceAppListUseCase: GetEditorsChoiceAppListUseCase
): ViewModel() {


    private val _localTopAppsList = MutableLiveData<List<App>>()
    val localTopAppsList : LiveData<List<App>> = _localTopAppsList

    private val _editorChoiceAppsList = MutableLiveData<List<App>>()
    val editorChoiceAppsList : LiveData<List<App>> = _editorChoiceAppsList

    private val _loading = MutableLiveData<Boolean>()
    val loading : LiveData<Boolean> = _loading


    private val _error = MutableLiveData<String>()
    val error : LiveData<String> = _error

    fun getAppList() {
        _loading.postValue(true)
        viewModelScope.launch {
            getLocalTopAppsListUseCase().subscribe { result ->
                when (result) {
                    is Resource.Success -> {
                        _localTopAppsList.postValue(result.data!!)
                        _loading.postValue(false)
                    }

                    is Resource.Error -> {
                        _error.postValue(result.message!!)
                        _loading.postValue(false)
                    }
                }
            }

            getEditorsChoiceAppListUseCase().subscribe { result ->
                when (result) {
                    is Resource.Success -> {
                        _editorChoiceAppsList.postValue(result.data!!)
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