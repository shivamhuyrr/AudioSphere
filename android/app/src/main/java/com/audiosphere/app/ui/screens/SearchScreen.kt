package com.audiosphere.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlin.random.Random

data class Category(val name: String, val color: Color)

val categories = listOf(
    Category("Music", Color(0xFFE91E63)),
    Category("Podcasts", Color(0xFF009688)),
    Category("Live Events", Color(0xFF673AB7)),
    Category("Made For You", Color(0xFF3F51B5)),
    Category("New Releases", Color(0xFFE040FB)),
    Category("Hindi", Color(0xFFFF5722)),
    Category("Punjabi", Color(0xFF4CAF50)),
    Category("Tamil", Color(0xFFFF9800)),
    Category("Telugu", Color(0xFF00BCD4)),
    Category("Charts", Color(0xFF9C27B0))
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {
    var query by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        Text(
            text = "Search",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        SearchBar(
            query = query,
            onQueryChange = { query = it },
            onSearch = { active = false },
            active = false, // Keep it simple for now
            onActiveChange = { active = it },
            placeholder = { Text("What do you want to listen to?") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        ) {}

        Text(
            text = "Browse all",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(categories) { category ->
                CategoryCard(category)
            }
        }
    }
}

@Composable
fun CategoryCard(category: Category) {
    Box(
        modifier = Modifier
            .aspectRatio(1.6f)
            .clip(RoundedCornerShape(8.dp))
            .background(category.color)
            .padding(16.dp),
        contentAlignment = Alignment.TopStart
    ) {
        Text(
            text = category.name,
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}
