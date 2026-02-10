const express = require('express');
const router = express.Router();
const { protect } = require('../middleware/authMiddleware');
const Track = require('../models/Track');

// @desc    Search tracks
// @route   GET /api/tracks/search
// @access  Private
router.get('/search', protect, async (req, res) => {
    const { query } = req.query;

    if (!query) {
        return res.status(400).json({ message: 'Query parameter is required' });
    }

    try {
        // Simple case-insensitive regex search
        // Mock data for testing since DB is not connected
        const mockTracks = [
            { id: 1, title: "Liked Songs", artist: "Auto Playlist", audioUrl: "https://storage.googleapis.com/uamp/The_Kyoto_Connection_-_Wake_Up/01_-_Intro_-_The_Kyoto_Connection_-_Wake_Up.mp3" },
            { id: 2, title: "Rock Classics", artist: "Playlist • AudioSphere", audioUrl: "https://storage.googleapis.com/uamp/Kai_Engel_-_Irsen_s_Tale/02_-_Irsen_s_Tale_-_Kai_Engel_-_Irsen_s_Tale.mp3" },
            { id: 3, title: "Late Night Lo-Fi", artist: "Playlist • User", audioUrl: "https://storage.googleapis.com/uamp/The_Kyoto_Connection_-_Wake_Up/01_-_Intro_-_The_Kyoto_Connection_-_Wake_Up.mp3" },
            { id: 4, title: "Podcast: Tech Talk", artist: "Podcast", audioUrl: "https://storage.googleapis.com/uamp/Kai_Engel_-_Irsen_s_Tale/02_-_Irsen_s_Tale_-_Kai_Engel_-_Irsen_s_Tale.mp3" }
        ];
        res.json(mockTracks);

        /* 
        const tracks = await Track.find({
            $or: [
                { title: { $regex: query, $options: 'i' } },
                { artist: { $regex: query, $options: 'i' } },
                { album: { $regex: query, $options: 'i' } }
            ]
        }).limit(20);

        res.json(tracks);
        */
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
});

// @desc    Get track by ID
// @route   GET /api/tracks/:id
// @access  Private
router.get('/:id', protect, async (req, res) => {
    try {
        const track = await Track.findById(req.params.id);

        if (track) {
            res.json(track);
        } else {
            res.status(404).json({ message: 'Track not found' });
        }
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
});

module.exports = router;
