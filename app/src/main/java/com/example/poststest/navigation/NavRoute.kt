package com.example.poststest.navigation

sealed class NavRoute(val path: String) {

    object Users : NavRoute("users")

    object Posts : NavRoute("posts") {
        const val id = "id"
    }

    fun withArgs(vararg args: Int) = buildString {
        append(path)
        args.forEach { arg ->
            append("/$arg")
        }
    }

    fun withArgsFormat(vararg args: String) = buildString {
        append(path)
        args.forEach { arg ->
            append("/{$arg}")
        }
    }
}