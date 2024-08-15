package com.hmncube.template.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hmncube.template.data.response.Post
import com.hmncube.template.domain.usecase.GetDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getDataUseCase: GetDataUseCase
) : ViewModel() {
    val posts = mutableStateOf<List<Post>>(emptyList())

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            posts.value = getDataUseCase.execute()
        }
    }
}

