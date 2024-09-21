import React from "react";
import "./App.css";
import { BrowserRouter } from "react-router-dom";
import Router from "./routes/Routes";
import NavBar from "./ui/navbar/Navbar";

const App: React.FC = () => {
  return (
    <>
      <BrowserRouter>
        <NavBar />
        <Router />
      </BrowserRouter>
    </>
  );
};

export default App;
