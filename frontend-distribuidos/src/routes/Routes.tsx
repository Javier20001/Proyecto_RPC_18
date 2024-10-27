import { Routes, Route } from "react-router-dom";
import Home from "../ui/pages/Home";
import LoginPage from "../ui/pages/Login";
import Store from "../ui/pages/Store";
import User from "../ui/pages/User";
import Product from "../ui/pages/Products";
import ProtectedRoute from "./ProtectedRoute";
import PurchaseOrder from "../ui/pages/PurchaseOrders";
import News from "../ui/pages/News";

const Router = () => {
  return (
    <Routes>
      <Route path="/" element={<LoginPage />} />

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
      <Route
        path="/PurchaseOrder"
        element={
          <ProtectedRoute>
            <PurchaseOrder />
          </ProtectedRoute>
        }
      />
      <Route
        path="/News"
        element={
          <ProtectedRoute>
            <News />
          </ProtectedRoute>
        }
      />
    </Routes>
  );
};

export default Router;
