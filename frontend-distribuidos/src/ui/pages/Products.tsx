import React from "react";
import ProductLis from "../../components/list/ProductList";
import { ProductoEnTiendaProvider } from "../../hooks/ProductContext";

const Product: React.FC = () => {
  return (
    <div>
      <ProductoEnTiendaProvider>
        <ProductLis />
      </ProductoEnTiendaProvider>
    </div>
  );
};

export default Product;
