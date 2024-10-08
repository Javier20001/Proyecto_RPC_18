import React from "react";
import "./App.css";
import { BrowserRouter } from "react-router-dom";
import Router from "./routes/Routes";
import NavBar from "./ui/navbar/Navbar";
import { ProductoEnTiendaProvider } from "../src/hooks/ProductContext";
import { StoreProvider } from "../src/hooks/StoreContext";
import { AuthProvider } from "./hooks/AuthContext"; // Asegúrate de importar AuthProvider

import { UserProvider } from "./hooks/UserContext";
const App: React.FC = () => {
  return (
    <BrowserRouter>
      <AuthProvider>
        <StoreProvider>
          <ProductoEnTiendaProvider>
            <UserProvider>
              <NavBar />
              <Router />
            </UserProvider>
          </ProductoEnTiendaProvider>
        </StoreProvider>
      </AuthProvider>
    </BrowserRouter>
  );
};

export default App;
