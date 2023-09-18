package com.example.posts.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.posts.domain.PostUiModel
import com.example.theme.PostsTestTheme
import com.example.theme.Typography

// todo сделать api для модуля
@Composable
fun PostsScreen(
    userId: Int,
    postViewModel: PostsViewModel = hiltViewModel(),
) {
    postViewModel.loadData(userId)

    val uiState by postViewModel.uiState.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val itemModifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        LazyColumn {
            items(uiState.posts) {
                PostRow(modifier = itemModifier, post = it)
                Divider(color = Color.Gray)
            }
        }
    }
}

@Composable
fun PostRow(modifier: Modifier = Modifier, post: PostUiModel) {
    Column(modifier) {
        Text(text = post.body, style = Typography.titleLarge)
        Text(text = post.title, style = Typography.bodyMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PostsTestTheme {
        PostsScreen(userId = 1)
    }
}