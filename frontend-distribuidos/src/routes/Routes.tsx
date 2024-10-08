import { Routes, Route } from "react-router-dom";
import Home from "../ui/pages/Home";
import LoginPage from "../ui/pages/Login";
import Store from "../ui/pages/Store";
import User from "../ui/pages/User";
import Product from "../ui/pages/Products";
import ProtectedRoute from "./ProtectedRoute"; // Importa el ProtectedRoute

const Router = () => {
  return (
    <Routes>
      {/* La ruta de login está libre */}
      <Route path="/" element={<LoginPage />} />

      {/* Rutas protegidas */}
      <Route
        path="/home"
        element={
          <ProtectedRoute>
            <Home />
          </ProtectedRoute>
        }
      />
      <Route
        path="/Store"
        element={
          <ProtectedRoute>
            <Store />
          </ProtectedRoute>
        }
      />
      <Route
        path="/User"
        element={
          <ProtectedRoute>
            <User />
          </ProtectedRoute>
        }
      />
      <Route
        path="/Products"
        element={
          <ProtectedRoute>
            <Product />
          </ProtectedRoute>
        }
      />
    </Routes>
  );
};

export default Router;
