import React from 'react';
import Sidebar from './Sidebar';
import PlayerBar from './PlayerBar';
import TopBar from './TopBar';

interface LayoutProps {
    children: React.ReactNode;
}

const Layout: React.FC<LayoutProps> = ({ children }) => {
    return (
        <div className="flex h-screen flex-col">
            <div className="flex flex-1 overflow-hidden">
                <Sidebar />
                <div className="flex-1 flex flex-col relative bg-[#121212]">
                    <TopBar />
                    <main className="flex-1 overflow-y-auto p-6 bg-gradient-to-b from-[#1e1e1e] to-[#121212]">
                        {children}
                    </main>
                </div>
            </div>
            <PlayerBar />
        </div>
    );
};

export default Layout;
