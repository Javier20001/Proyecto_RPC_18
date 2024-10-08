import React from "react";
import { Navigate } from "react-router-dom";

// Simulamos una función que revisa si hay un token de autenticación en el localStorage
const isAuthenticated = () => {
  return !!localStorage.getItem("token");
};

interface ProtectedRouteProps {
  children: JSX.Element;
}

const ProtectedRoute: React.FC<ProtectedRouteProps> = ({ children }) => {
  // Si el usuario no está autenticado, redirige al login
  if (!isAuthenticated()) {
    return <Navigate to="/" replace />;
  }

  // Si está autenticado, muestra el componente correspondiente
  return children;
};

export default ProtectedRoute;
