package com.audiosphere.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.audiosphere.app.R
import com.audiosphere.app.ui.theme.AudioSphereTheme

// Mock Data Models
data class PlaylistItem(val id: Int, val title: String, val subtitle: String, val imageUrl: String = "")

val mockRecentlyPlayed = listOf(
    PlaylistItem(1, "Liked Songs", "Auto Playlist"),
    PlaylistItem(2, "Rock Classics", "Playlist • AudioSphere"),
    PlaylistItem(3, "Late Night Lo-Fi", "Playlist • User"),
    PlaylistItem(4, "Podcast: Tech Talk", "Podcast")
)

val mockMadeForYou = listOf(
    PlaylistItem(5, "Discover Weekly", "Playlist • AudioSphere"),
    PlaylistItem(6, "Daily Mix 1", "For You"),
    PlaylistItem(7, "Release Radar", "New Music"),
    PlaylistItem(8, "On Repeat", "Songs you love")
)

@Composable
fun HomeScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        item {
            GreetingHeader()
        }

        item {
            HScrollSection(title = "Recently Played", items = mockRecentlyPlayed)
        }

        item {
            HScrollSection(title = "Made For You", items = mockMadeForYou)
        }
        
        item {
            HScrollSection(title = "VLC Local Media", items = listOf(
                PlaylistItem(9, "Downloads", "Local Folder"),
                PlaylistItem(10, "Music", "Local Folder"),
            ))
        }
    }
}

@Composable
fun GreetingHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Good Evening",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )
        // Icon(Icons.Default.Settings, contentDescription = "Settings", tint = MaterialTheme.colorScheme.onBackground)
    }
}

@Composable
fun HScrollSection(title: String, items: List<PlaylistItem>) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(end = 16.dp)
        ) {
            items(items) { item ->
                PlaylistItemCard(item)
            }
        }
    }
}

@Composable
fun PlaylistItemCard(item: PlaylistItem) {
    Column(
        modifier = Modifier.width(140.dp)
    ) {
        Box(
            modifier = Modifier
                .size(140.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(Color.DarkGray) // Placeholder color
        )
        // Image(painter = painterResource(id = R.drawable.placeholder), ...)
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = item.title,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1
        )
        Text(
            text = item.subtitle,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
            maxLines = 2
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AudioSphereTheme {
        HomeScreen()
    }
}
