package com.example.users.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.theme.PostsTestTheme
import com.example.theme.Typography
import com.example.users.domain.UserUiModel

// todo сделать api для модуля
@Composable
fun UsersScreen(
    usersViewModel: UsersViewModel = hiltViewModel(),
    onUserClick: (userId: Int) -> Unit
) {
    usersViewModel.loadData()

    val uiState by usersViewModel.uiState.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val itemModifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)
        LazyColumn {
            items(uiState.users) {
                UserRow(itemModifier, it, onUserClick)
                Divider(color = Color.Gray)
            }
        }
    }
}

@Composable
fun UserRow(
    modifier: Modifier = Modifier,
    user: UserUiModel,
    onUserClick: (userId: Int) -> Unit
) {
    Column(
        modifier = modifier.clickable {
            onUserClick(user.id)
        }
    ) {
        Text(text = user.name, style = Typography.titleLarge)
        Text(text = user.email, style = Typography.bodyMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PostsTestTheme {
        UsersScreen {}
    }
}