package com.hmncube.template.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.hmncube.template.presentation.viewmodel.MainViewModel

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    val posts by viewModel.posts

    LazyColumn {
        items(posts) { post ->
            Text(text = post.title, style = MaterialTheme.typography.titleLarge)
            Text(text = post.body, style = MaterialTheme.typography.bodyMedium)
            Divider()
        }
    }
}
