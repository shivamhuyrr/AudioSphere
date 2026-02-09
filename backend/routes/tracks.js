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
        const tracks = await Track.find({
            $or: [
                { title: { $regex: query, $options: 'i' } },
                { artist: { $regex: query, $options: 'i' } },
                { album: { $regex: query, $options: 'i' } }
            ]
        }).limit(20);

        res.json(tracks);
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
