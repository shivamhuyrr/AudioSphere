import React from 'react';

const Library = () => {
    return (
        <div className="text-white">
            <h2 className="text-2xl font-bold mb-6">Playlists</h2>
            <div className="grid grid-cols-2 md:grid-cols-4 lg:grid-cols-6 gap-6">
                {/* Playlist Grid */}
                <div className="bg-gradient-to-br from-[#450af5] to-[#8e8ee5] col-span-2 row-span-2 rounded-lg p-6 flex flex-col justify-end cursor-pointer">
                    <div className="mb-4">
                        <span className="text-sm font-medium">Auto Playlist</span>
                        <h3 className="text-3xl font-bold mt-2">Liked Songs</h3>
                        <p className="mt-2 text-sm font-medium">120 liked songs</p>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Library;
