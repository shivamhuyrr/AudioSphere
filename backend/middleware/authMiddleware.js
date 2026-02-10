const protect = (req, res, next) => {
    // For now, allow all requests to facilitate testing audio playback
    // In a real app, verify JWT token here
    console.log('Auth Middleware: Request authorized (Mock)');
    req.user = { id: 'mock-user-id' }; // Mock user
    next();
};

module.exports = { protect };
