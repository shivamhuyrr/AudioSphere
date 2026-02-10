const mongoose = require('mongoose');

const trackSchema = new mongoose.Schema({
    title: {
        type: String,
        required: [true, 'Please add a track title'],
        trim: true
    },
    artist: {
        type: String,
        required: [true, 'Please add an artist name'],
        trim: true
    },
    album: {
        type: String,
        required: false,
        trim: true
    },
    duration: {
        type: Number, // Duration in seconds
        required: false
    },
    audioUrl: {
        type: String,
        required: [true, 'Please add an audio URL'], // Essential for playback
        trim: true
    },
    imageUrl: {
        type: String, // Album art
        required: false,
        trim: true
    },
    genre: {
        type: String,
        required: false,
        trim: true
    },
    createdAt: {
        type: Date,
        default: Date.now
    }
});

module.exports = mongoose.model('Track', trackSchema);
