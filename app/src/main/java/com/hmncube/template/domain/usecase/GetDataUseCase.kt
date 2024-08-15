package com.hmncube.template.domain.usecase

import com.hmncube.template.data.repository.DataRepository
import com.hmncube.template.data.response.Post
import javax.inject.Inject

class GetDataUseCase @Inject constructor(
    private val repository: DataRepository
) {
    suspend fun execute(): List<Post> {
        return repository.getPosts()
    }
}
