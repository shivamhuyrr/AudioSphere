import { ChevronLeft, ChevronRight, User } from 'lucide-react';

const TopBar = () => {
    return (
        <header className="h-16 bg-[#101010] flex items-center justify-between px-6 sticky top-0 z-10 w-full bg-opacity-95 backdrop-blur-md">
            <div className="flex gap-4">
                <button className="bg-black/70 rounded-full p-1 cursor-not-allowed">
                    <ChevronLeft color="white" size={22} />
                </button>
                <button className="bg-black/70 rounded-full p-1 cursor-not-allowed">
                    <ChevronRight color="#b3b3b3" size={22} />
                </button>
            </div>

            <div className="flex items-center gap-4">
                <button className="text-[#b3b3b3] hover:text-white font-semibold text-sm hover:scale-105 transition-transform uppercase tracking-widest">
                    Sign up
                </button>
                <button className="bg-white text-black font-bold px-8 py-3 rounded-full hover:scale-105 transition-transform text-sm uppercase tracking-widest">
                    Log in
                </button>
            </div>
        </header>
    );
};

export default TopBar;
