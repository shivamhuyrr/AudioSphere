import { Home, Search, Library, PlusSquare, Heart } from 'lucide-react';
import { Link, useLocation } from 'react-router-dom';

const Sidebar = () => {
    const location = useLocation();

    const isActive = (path: string) => location.pathname === path;

    const NavItem = ({ to, icon: Icon, label }: { to: string, icon: any, label: string }) => (
        <Link
            to={to}
            className={`flex items-center gap-4 px-4 py-3 transition-colors ${isActive(to) ? 'text-white' : 'text-[#b3b3b3] hover:text-white'
                }`}
        >
            <Icon size={24} strokeWidth={isActive(to) ? 3 : 2} />
            <span className={`font-medium ${isActive(to) ? 'font-bold' : ''}`}>{label}</span>
        </Link>
    );

    return (
        <div className="w-[240px] bg-black flex flex-col h-full pt-6">
            <div className="px-6 mb-6">
                <h1 className="text-2xl font-bold text-white tracking-tight">AudioSphere</h1>
            </div>

            <nav className="flex-1">
                <div className="mb-6">
                    <NavItem to="/" icon={Home} label="Home" />
                    <NavItem to="/search" icon={Search} label="Search" />
                    <NavItem to="/library" icon={Library} label="Your Library" />
                </div>

                <div className="mt-6 px-4">
                    <button className="flex items-center gap-4 px-4 py-2 text-[#b3b3b3] hover:text-white w-full transition-colors group">
                        <div className="w-6 h-6 bg-[#b3b3b3] group-hover:bg-white flex items-center justify-center rounded-[2px] text-black">
                            <PlusSquare size={16} fill="currentColor" />
                        </div>
                        <span className="font-medium">Create Playlist</span>
                    </button>
                    <button className="flex items-center gap-4 px-4 py-2 text-[#b3b3b3] hover:text-white w-full transition-colors group mt-2">
                        <div className="w-6 h-6 bg-gradient-to-br from-[#450af5] to-[#c4efd9] flex items-center justify-center rounded-[2px] opacity-70 group-hover:opacity-100">
                            <Heart size={12} fill="white" color="white" />
                        </div>
                        <span className="font-medium">Liked Songs</span>
                    </button>
                </div>

                <div className="mt-4 px-6 border-t border-[#282828] pt-4">
                    {/* Playlist scroll list would go here */}
                    <p className="text-sm text-[#b3b3b3] py-1 cursor-pointer hover:text-white">Chill Vibes</p>
                    <p className="text-sm text-[#b3b3b3] py-1 cursor-pointer hover:text-white">Rock Classics</p>
                    <p className="text-sm text-[#b3b3b3] py-1 cursor-pointer hover:text-white">Focus Flow</p>
                </div>
            </nav>
        </div>
    );
};

export default Sidebar;
