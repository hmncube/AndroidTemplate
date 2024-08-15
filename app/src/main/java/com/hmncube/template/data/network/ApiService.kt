package com.hmncube.template.data.network

import com.hmncube.template.data.response.Post
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>
}
