package com.audiosphere.app.data.repository

import android.content.ComponentName
import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.session.MediaController
import androidx.media3.session.SessionToken
import com.audiosphere.app.service.AudioPlayerService
import com.audiosphere.app.ui.screens.PlaylistItem // Reuse effectively for now
import com.google.common.util.concurrent.ListenableFuture
import com.google.common.util.concurrent.MoreExecutors

class AudioRepository(private valcontext: Context) {

    private var mediaControllerFuture: ListenableFuture<MediaController>? = null
    private var mediaController: MediaController? = null

    fun initializeController(onReady: () -> Unit) {
        val sessionToken = SessionToken(context, ComponentName(context, AudioPlayerService::class.java))
        mediaControllerFuture = MediaController.Builder(context, sessionToken).buildAsync()
        mediaControllerFuture?.addListener({
            mediaController = mediaControllerFuture?.get()
            onReady()
        }, MoreExecutors.directExecutor())
    }

    fun play(item: PlaylistItem) {
        mediaController?.let { controller ->
            // For demo, we are just using a sample URL since we don't have real audio files yet
            // In a real app, this would come from the item.
            val mediaItem = MediaItem.fromUri("https://storage.googleapis.com/uamp/The_Kyoto_Connection_-_Wake_Up/01_-_Intro_-_The_Kyoto_Connection_-_Wake_Up.mp3")
            controller.setMediaItem(mediaItem)
            controller.prepare()
            controller.play()
        }
    }

    fun pause() {
        mediaController?.pause()
    }

    fun release() {
        mediaControllerFuture?.let { MediaController.releaseFuture(it) }
    }
}
