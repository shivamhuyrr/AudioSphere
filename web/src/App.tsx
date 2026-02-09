import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Search from './pages/Search';
import Library from './pages/Library';
import Layout from './components/Layout';

function App() {
    return (
        <Router>
            <Layout>
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/search" element={<Search />} />
                    <Route path="/library" element={<Library />} />
                </Routes>
            </Layout>
        </Router>
    );
}

export default App;
