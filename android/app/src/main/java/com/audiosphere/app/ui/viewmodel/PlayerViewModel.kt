package com.audiosphere.app.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.audiosphere.app.data.repository.AudioRepository
import com.audiosphere.app.ui.screens.PlaylistItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PlayerViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = AudioRepository(application)
    
    private val _isPlaying = MutableStateFlow(false)
    val isPlaying: StateFlow<Boolean> = _isPlaying.asStateFlow()

    private val _currentTrack = MutableStateFlow<PlaylistItem?>(null)
    val currentTrack: StateFlow<PlaylistItem?> = _currentTrack.asStateFlow()

    init {
        repository.initializeController {
            // Ready
        }
    }

    fun playTrack(item: PlaylistItem) {
        _currentTrack.value = item
        _isPlaying.value = true
        repository.play(item)
    }

    fun togglePlayPause() {
        if (_isPlaying.value) {
            repository.pause()
            _isPlaying.value = false
        } else {
            // Resume or play
            // Simple toggle logic for demo
            _currentTrack.value?.let { repository.play(it) }
             _isPlaying.value = true
        }
    }

    override fun onCleared() {
        super.onCleared()
        repository.release()
    }
}
