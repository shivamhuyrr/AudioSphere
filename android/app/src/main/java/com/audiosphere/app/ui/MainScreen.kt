package com.audiosphere.app.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.audiosphere.app.navigation.AudioSphereNavHost
import com.audiosphere.app.navigation.Screen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.audiosphere.app.ui.components.MiniPlayer

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    // In a real app, use Hilt or a proper ViewModel provider
    val viewModel: com.audiosphere.app.ui.viewmodel.PlayerViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    val currentTrack by viewModel.currentTrack.collectAsState()
    val isPlaying by viewModel.isPlaying.collectAsState()

    Scaffold(
        bottomBar = {
            Column {
                currentTrack?.let { track ->
                    com.audiosphere.app.ui.components.MiniPlayer(
                        currentTrack = track,
                        isPlaying = isPlaying,
                        onPlayPauseClick = { viewModel.togglePlayPause() }
                    )
                }
                NavigationBar {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    val items = listOf(
                        Screen.Home to Icons.Default.Home,
                        Screen.Search to Icons.Default.Search,
                        Screen.Library to Icons.Default.List
                    )

                    items.forEach { (screen, icon) ->
                        NavigationBarItem(
                            icon = { Icon(icon, contentDescription = screen.route) },
                            label = { Text(screen.route.replaceFirstChar { it.uppercase() }) },
                            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        // Apply modifier to respect bottom bar padding
        androidx.compose.foundation.layout.Box(modifier = Modifier.padding(innerPadding)) {
            AudioSphereNavHost(navController = navController, playerViewModel = viewModel)
        }
    }
}
