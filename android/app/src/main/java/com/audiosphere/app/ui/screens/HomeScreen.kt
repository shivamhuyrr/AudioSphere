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
data class PlaylistItem(val id: Int, val title: String, val subtitle: String, val imageUrl: String = "", val mediaUrl: String = "")

val mockRecentlyPlayed = listOf(
    PlaylistItem(1, "Liked Songs", "Auto Playlist", "", "https://storage.googleapis.com/uamp/The_Kyoto_Connection_-_Wake_Up/01_-_Intro_-_The_Kyoto_Connection_-_Wake_Up.mp3"),
    PlaylistItem(2, "Rock Classics", "Playlist • AudioSphere", "", "https://storage.googleapis.com/uamp/Kai_Engel_-_Irsen_s_Tale/02_-_Irsen_s_Tale_-_Kai_Engel_-_Irsen_s_Tale.mp3"),
    PlaylistItem(3, "Late Night Lo-Fi", "Playlist • User", "", "https://storage.googleapis.com/uamp/The_Kyoto_Connection_-_Wake_Up/01_-_Intro_-_The_Kyoto_Connection_-_Wake_Up.mp3"),
    PlaylistItem(4, "Podcast: Tech Talk", "Podcast", "", "https://storage.googleapis.com/uamp/Kai_Engel_-_Irsen_s_Tale/02_-_Irsen_s_Tale_-_Kai_Engel_-_Irsen_s_Tale.mp3")
)

val mockMadeForYou = listOf(
    PlaylistItem(5, "Discover Weekly", "Playlist • AudioSphere", "", "https://storage.googleapis.com/uamp/The_Kyoto_Connection_-_Wake_Up/01_-_Intro_-_The_Kyoto_Connection_-_Wake_Up.mp3"),
    PlaylistItem(6, "Daily Mix 1", "For You", "", "https://storage.googleapis.com/uamp/Kai_Engel_-_Irsen_s_Tale/02_-_Irsen_s_Tale_-_Kai_Engel_-_Irsen_s_Tale.mp3"),
    PlaylistItem(7, "Release Radar", "New Music", "", "https://storage.googleapis.com/uamp/The_Kyoto_Connection_-_Wake_Up/01_-_Intro_-_The_Kyoto_Connection_-_Wake_Up.mp3"),
    PlaylistItem(8, "On Repeat", "Songs you love", "", "https://storage.googleapis.com/uamp/Kai_Engel_-_Irsen_s_Tale/02_-_Irsen_s_Tale_-_Kai_Engel_-_Irsen_s_Tale.mp3")
)

@Composable
fun HomeScreen(onTrackClick: (PlaylistItem) -> Unit = {}) {
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
            HScrollSection(title = "Recently Played", items = mockRecentlyPlayed, onItemClick = onTrackClick)
        }

        item {
            HScrollSection(title = "Made For You", items = mockMadeForYou, onItemClick = onTrackClick)
        }
        
        item {
            HScrollSection(title = "VLC Local Media", items = listOf(
                PlaylistItem(9, "Downloads", "Local Folder", "", "https://storage.googleapis.com/uamp/The_Kyoto_Connection_-_Wake_Up/01_-_Intro_-_The_Kyoto_Connection_-_Wake_Up.mp3"),
                PlaylistItem(10, "Music", "Local Folder", "", "https://storage.googleapis.com/uamp/Kai_Engel_-_Irsen_s_Tale/02_-_Irsen_s_Tale_-_Kai_Engel_-_Irsen_s_Tale.mp3"),
            ), onItemClick = onTrackClick)
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
fun HScrollSection(title: String, items: List<PlaylistItem>, onItemClick: (PlaylistItem) -> Unit) {
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
                PlaylistItemCard(item, onClick = { onItemClick(item) })
            }
        }
    }
}

@Composable
fun PlaylistItemCard(item: PlaylistItem, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .width(140.dp)
            .clickable { onClick() }
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
