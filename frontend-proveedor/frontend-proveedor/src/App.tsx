import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import PageProveedor from './pages/PageProveedor';




const App: React.FC = () => {
  return (
    <Router>
      <Routes>
        <Route path="/proveedor" element={<PageProveedor />} />
        {/* Aquí puedes agregar más rutas a otras páginas */}
      </Routes>
    </Router>
  );
};

export default App;
