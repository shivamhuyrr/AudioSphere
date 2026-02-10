package com.audiosphere.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.ui.Modifier
import com.audiosphere.app.ui.screens.HomeScreen
import com.audiosphere.app.ui.viewmodel.PlayerViewModel
import com.audiosphere.app.ui.screens.LibraryScreen
import com.audiosphere.app.ui.screens.SearchScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Search : Screen("search")
    object Library : Screen("library")
}

@Composable
fun AudioSphereNavHost(navController: NavHostController, playerViewModel: PlayerViewModel) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { 
            HomeScreen(onTrackClick = { track -> playerViewModel.playTrack(track) }) 
        }
        composable(Screen.Search.route) { SearchScreen() }
        composable(Screen.Library.route) { LibraryScreen() }
    }
}
