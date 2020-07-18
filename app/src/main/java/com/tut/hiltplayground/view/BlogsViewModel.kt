package com.tut.hiltplayground.view

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.tut.hiltplayground.model.Blog
import com.tut.hiltplayground.repository.BlogsRepository
import com.tut.hiltplayground.utils.DataState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


class BlogsViewModel @ViewModelInject constructor(
    private val blogsRepository: BlogsRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Blog>>> = MutableLiveData()
    val dataState: LiveData<DataState<List<Blog>>>
        get() = _dataState

    fun setState(mainDataState: MainDataState) {
        when(mainDataState){
            is MainDataState.GetBlogsEvents ->{
                viewModelScope.launch {
                    blogsRepository.getBlogs().onEach {
                        _dataState.postValue(it)
                    }.launchIn(viewModelScope)
                }
            }
            is MainDataState.None ->{

            }
        }

    }


}

sealed class MainDataState {
    object GetBlogsEvents : MainDataState()
    object None : MainDataState()
}