package com.hmncube.template.data.repository

import com.hmncube.template.data.local.daos.PostDao
import com.hmncube.template.data.local.entities.PostEntity
import com.hmncube.template.data.network.ApiService
import com.hmncube.template.data.response.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val apiService: ApiService,
    private val postDao: PostDao
) {
    suspend fun getPosts(): List<Post> {
        val response = apiService.getPosts()
        if (response.isSuccessful) {
            val posts = response.body()
            return if (posts?.isNotEmpty() == true) {
                withContext(Dispatchers.IO) {
                    posts.map { post -> PostEntity(post.id, post.title, post.body) }
                        .let { postDao.insertPosts(it) }
                }
                posts
            } else {
                //return from DB
                emptyList()
            }
        } else {
            throw Exception("Failed to load posts")
        }
    }
}
