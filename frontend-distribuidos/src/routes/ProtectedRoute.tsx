import React from "react";
import { Navigate } from "react-router-dom";

const isAuthenticated = () => {
  return !!localStorage.getItem("token");
};

interface ProtectedRouteProps {
  children: JSX.Element;
}

const ProtectedRoute: React.FC<ProtectedRouteProps> = ({ children }) => {
  if (!isAuthenticated()) {
    return <Navigate to="/" replace />;
  }

  return children;
};

export default ProtectedRoute;
