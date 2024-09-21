import React from "react";
import "./App.css";
import { BrowserRouter } from "react-router-dom";
import Router from "./routes/Routes";
import NavBar from "./ui/navbar/Navbar";
import { ProductoEnTiendaProvider } from "../src/hooks/ProductContext";
import { StoreProvider } from "../src/hooks/StoreContext";
const App: React.FC = () => {
  return (
    <>
      <BrowserRouter>
        <StoreProvider>
          <ProductoEnTiendaProvider>
            <NavBar />
            <Router />
          </ProductoEnTiendaProvider>
        </StoreProvider>
      </BrowserRouter>
    </>
  );
};

export default App;
