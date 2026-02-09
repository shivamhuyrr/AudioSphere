const express = require('express');
const router = express.Router();
const { protect } = require('../middleware/authMiddleware');
const History = require('../models/History');
const Track = require('../models/Track');

// @desc    Get listening history
// @route   GET /api/history
// @access  Private
router.get('/', protect, async (req, res) => {
    try {
        const history = await History.find({ user: req.user._id })
            .sort({ playedAt: -1 })
            .limit(50)
            .populate('track');
        res.json(history);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
});

// @desc    Add track to history
// @route   POST /api/history
// @access  Private
router.post('/', protect, async (req, res) => {
    const { trackId } = req.body;

    try {
        const history = new History({
            user: req.user._id,
            track: trackId,
        });

        await history.save();
        res.status(201).json(history);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
});

// @desc    Get recommendations
// @route   GET /api/recommendations
// @access  Private
router.get('/recommendations', protect, async (req, res) => {
    try {
        // Simple recommendation logic: get random tracks excluding history (mock implementation)
        // In a real app, this would be more sophisticated based on history/genres
        const totalTracks = await Track.countDocuments();
        const randomTracks = await Track.aggregate([{ $sample: { size: 10 } }]);

        // Populate if needed, though aggregate returns raw objects
        // If strict model instances needed: await Track.hydrate(randomTracks)

        res.json(randomTracks);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
});

module.exports = router;
