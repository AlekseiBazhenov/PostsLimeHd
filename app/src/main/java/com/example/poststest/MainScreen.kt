package com.example.poststest

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.poststest.navigation.AppNavGraph
import com.example.theme.PostsTestTheme

@Composable
fun AppScreen() {
    PostsTestTheme {
        val navController = rememberNavController()
        AppNavGraph(navController)
    }
}