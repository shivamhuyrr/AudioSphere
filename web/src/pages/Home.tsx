import React from 'react';

const Home = () => {
    return (
        <div className="text-white">
            <h2 className="text-3xl font-bold mb-6">Good evening</h2>
            <div className="grid grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4 mb-8">
                {/* Quick access cards */}
                {[1, 2, 3, 4, 5, 6].map((i) => (
                    <div key={i} className="bg-[#2a2a2a] hover:bg-[#3a3a3a] transition-colors rounded-md flex items-center overflow-hidden cursor-pointer group">
                        <div className="w-16 h-16 bg-gradient-to-br from-indigo-500 to-purple-500 shrink-0"></div>
                        <span className="font-bold px-4 truncate">Daily Mix {i}</span>
                    </div>
                ))}
            </div>

            <h3 className="text-2xl font-bold mb-4">Made for you</h3>
            <div className="flex gap-6 overflow-x-auto pb-4">
                {/* Horizontal list */}
                {[1, 2, 3, 4, 5].map((i) => (
                    <div key={i} className="bg-[#181818] p-4 rounded-md hover:bg-[#282828] transition-colors cursor-pointer w-[180px] shrink-0 group">
                        <div className="w-full aspect-square bg-[#333] rounded-md mb-4 shadow-lg relative">
                            {/* Play button appears on hover */}
                        </div>
                        <h4 className="font-bold mb-1 truncate">Discover Weekly</h4>
                        <p className="text-sm text-[#b3b3b3] line-clamp-2">Your weekly mixtape of fresh music.</p>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default Home;
