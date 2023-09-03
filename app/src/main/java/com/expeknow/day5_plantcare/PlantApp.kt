package com.expeknow.day5_plantcare

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.expeknow.day5_plantcare.ui.window.DetailsWindow
import com.expeknow.day5_plantcare.ui.window.HomeWindow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val navController = rememberNavController()

    Scaffold {
        NavHost(navController = navController, startDestination = "home",
        modifier = Modifier.padding(it)) {
            composable(route = "home") {
                HomeWindow(navController)
            }

            composable(route = "details/{id}",
                arguments = listOf(
                    navArgument("id") {
                        type = NavType.IntType
                    }
                )
            ) {
                val id = it.arguments?.getInt("id")
                DetailsWindow(navController, id!!)
            }
        }
    }
}

fun NavGraphBuilder.graph(navController: NavController) {
    navigation(startDestination = "home", route = "home") {
        composable(route = "home") {
            HomeWindow(navController)
        }

        composable(route = "details/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) {
            val id = it.arguments?.getInt("id")
            DetailsWindow(navController, id!!)
        }
    }
}