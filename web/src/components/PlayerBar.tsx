import { Play, SkipBack, SkipForward, Repeat, Shuffle, Mic2, ListMusic, Speaker, Volume2 } from 'lucide-react';

const PlayerBar = () => {
    return (
        <footer className="h-[90px] bg-[#181818] border-t border-[#282828] flex items-center justify-between px-4 z-20">
            {/* Now Playing Area */}
            <div className="flex items-center w-[30%] min-w-[180px]">
                <div className="w-14 h-14 bg-gray-600 mr-4 shadow-sm"></div>
                <div className="flex flex-col justify-center mr-4">
                    <span className="text-white text-sm hover:underline cursor-pointer">Song Name</span>
                    <span className="text-[#b3b3b3] text-xs hover:underline cursor-pointer">Artist Name</span>
                </div>
                <button className="text-[#b3b3b3] hover:text-white">
                    {/* Add to Liked icon */}
                </button>
            </div>

            {/* Player Controls - Main Center */}
            <div className="flex flex-col items-center w-[40%] max-w-[722px]">
                <div className="flex items-center gap-6 mb-2">
                    <button className="text-[#b3b3b3] hover:text-white"><Shuffle size={16} /></button>
                    <button className="text-[#b3b3b3] hover:text-white"><SkipBack size={20} fill="currentColor" /></button>
                    <button className="bg-white rounded-full p-2 hover:scale-105 transition-transform">
                        <Play size={20} fill="black" color="black" className="ml-1" />
                    </button>
                    <button className="text-[#b3b3b3] hover:text-white"><SkipForward size={20} fill="currentColor" /></button>
                    <button className="text-[#b3b3b3] hover:text-white"><Repeat size={16} /></button>
                </div>
                <div className="w-full flex items-center gap-2 text-xs text-[#b3b3b3]">
                    <span>0:00</span>
                    <div className="h-1 bg-[#4d4d4d] rounded-full flex-1 group cursor-pointer relative">
                        <div className="h-full bg-white w-1/3 rounded-full group-hover:bg-[#1db954]"></div>
                        {/* Thumb handle would appear on hover logic */}
                    </div>
                    <span>3:45</span>
                </div>
            </div>

            {/* Extra Controls - Right */}
            <div className="flex items-center justify-end w-[30%] gap-3 min-w-[180px]">
                <button className="text-[#b3b3b3] hover:text-white"><Mic2 size={16} /></button>
                <button className="text-[#b3b3b3] hover:text-white"><ListMusic size={16} /></button>
                <button className="text-[#b3b3b3] hover:text-white"><Speaker size={16} /></button>
                <div className="flex items-center gap-2 w-32">
                    <Volume2 size={16} color="#b3b3b3" />
                    <div className="h-1 bg-[#b3b3b3] rounded-full flex-1 cursor-pointer"></div>
                </div>
            </div>
        </footer>
    );
};

export default PlayerBar;
