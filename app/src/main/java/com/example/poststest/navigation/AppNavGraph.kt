package com.example.poststest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.posts.presentation.PostsScreen
import com.example.users.presentation.UsersScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Users.path
    ) {
        composable(route = NavRoute.Users.path) {
            UsersScreen(
                onUserClick = { userId ->
                    navController.navigate(NavRoute.Posts.withArgs(userId))
                }
            )
        }
        composable(
            route = NavRoute.Posts.withArgsFormat(NavRoute.Posts.id),
            arguments = listOf(
                navArgument(NavRoute.Posts.id) {
                    type = NavType.IntType
                }
            )
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.let { bundle ->
                PostsScreen(
                    userId = bundle.getInt(NavRoute.Posts.id),
                )
            }
        }
    }
}