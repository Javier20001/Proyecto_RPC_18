import React from "react";
import ProductLis from "../../components/list/ProductList";
import ProductosFilter from "../../components/filter/ProductosFilter";
import "./css/PagesStyle.css";

const Product: React.FC = () => {
  return (
    <div className="page">
      <ProductosFilter />
      <ProductLis />
    </div>
  );
};

export default Product;
