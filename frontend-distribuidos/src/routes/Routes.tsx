import { Routes, Route } from "react-router-dom";

import Home from "../ui/pages/Home";
import Store from "../ui/pages/Store";
import User from "../ui/pages/User";
import Product from "../ui/pages/Products";

const Router = () => {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/Store" element={<Store />} />
      <Route path="/User" element={<User />} />
      <Route path="/Products" element={<Product />} />
    </Routes>
  );
};
export default Router;
