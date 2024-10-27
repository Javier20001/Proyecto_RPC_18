import React from "react";
import "./App.css";
import { BrowserRouter } from "react-router-dom";
import Router from "./routes/Routes";
import NavBar from "./ui/navbar/Navbar";
import { ProductoEnTiendaProvider } from "../src/hooks/ProductContext";
import { StoreProvider } from "../src/hooks/StoreContext";
import { AuthProvider } from "./hooks/AuthContext";
import { OrdenDeCompraProvider } from "./hooks/PurchaseOrderContext";
import { NewsProvider } from "./hooks/NewsContext";

import { UserProvider } from "./hooks/UserContext";
const App: React.FC = () => {
  return (
    <BrowserRouter>
      <AuthProvider>
        <StoreProvider>
          <ProductoEnTiendaProvider>
            <UserProvider>
              <OrdenDeCompraProvider>
                <NewsProvider>
                  <NavBar />
                  <Router />
                </NewsProvider>
              </OrdenDeCompraProvider>
            </UserProvider>
          </ProductoEnTiendaProvider>
        </StoreProvider>
      </AuthProvider>
    </BrowserRouter>
  );
};

export default App;
