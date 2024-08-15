package com.hmncube.template.data.repository

import com.hmncube.template.data.network.ApiService
import com.hmncube.template.data.response.Post
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getPosts(): List<Post> {
        val response = apiService.getPosts()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        } else {
            throw Exception("Failed to load posts")
        }
    }
}
