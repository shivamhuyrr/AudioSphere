import React from 'react';

const Search = () => {
    return (
        <div className="text-white">
            <h2 className="text-2xl font-bold mb-4">Browse All</h2>
            <div className="grid grid-cols-2 md:grid-cols-3 lg:grid-cols-5 gap-6">
                {['Music', 'Podcasts', 'Live Events', 'Made For You', 'New Releases', 'Hindi', 'Punjabi', 'Tamil', 'Telugu', 'Charts'].map((category, i) => (
                    <div
                        key={i}
                        className="aspect-video rounded-lg p-4 font-bold text-xl overflow-hidden relative cursor-pointer"
                        style={{ backgroundColor: `hsl(${i * 40}, 70%, 50%)` }}
                    >
                        {category}
                    </div>
                ))}
            </div>
        </div>
    );
};

export default Search;
