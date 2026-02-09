package com.audiosphere.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun LibraryScreen() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Playlists", "Artists", "Albums")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 16.dp)
    ) {
        Text(
            text = "Your Library",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        )

        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title) }
                )
            }
        }

        // Placeholder content for tabs
        Column(modifier = Modifier.padding(16.dp)) {
            when (selectedTabIndex) {
                0 -> PlaylistList()
                1 -> Text("Artists Content", color = MaterialTheme.colorScheme.onBackground)
                2 -> Text("Albums Content", color = MaterialTheme.colorScheme.onBackground)
            }
        }
    }
}

@Composable
fun PlaylistList() {
    Column {
        PlaylistItemCard(PlaylistItem(1, "Liked Songs", "120 songs"))
        // Add more list items here
    }
}
