import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import TopBar from './components/TopBar.tsx'; // Import ResponsiveAppBar component
import ExistingReservations from './components/ExistingReservations.js'; // Import ExistingReservations component
import Content from './components/Content/Content.js';
import RoomsPage from './components/Content/RoomsPage.js';

function App() {
  return (
    <Router>
      <div className="App">
        <TopBar /> {/* Add ResponsiveAppBar component */}
        <Routes>
          <Route exact path="/" element={<Content />} />
          <Route path="/hotel/:id/rooms" element={<RoomsPage />} />
          <Route path="/reservations" element={<ExistingReservations />} /> {/* Add route for ExistingReservations */}
        </Routes>
        <footer></footer>
      </div>
    </Router>
  );
}

export default App;
