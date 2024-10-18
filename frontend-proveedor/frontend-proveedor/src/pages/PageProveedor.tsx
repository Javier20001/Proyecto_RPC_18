import React, { useEffect, useState } from "react";
import ProductList from "../components/ProductList";
import { ProductProviderDTO } from "../redux/types";
import "./PageProveedor.css";


const PageProveedor: React.FC = () => {
  const [productos, setProductos] = useState<ProductProviderDTO[]>([]);
  
  const fetchProductos = async () => {
    try {
      const response = await fetch("http://localhost:8086/api/v1/proveedor");
      if (!response.ok) {
        throw new Error("Error al obtener los productos");
      }
      const data = await response.json();
      setProductos(data);
    } catch (error) {
      console.error("Error al obtener los productos:", error);
    }
  };

  useEffect(() => {
    fetchProductos();
  }, []);

  const addProducto = async (newProduct: ProductProviderDTO) => {
    try {
      const response = await fetch("http://localhost:8086/api/v1/proveedor", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(newProduct),
      });

      if (!response.ok) {
        throw new Error("Error al agregar el producto");
      }

      // Actualizar la lista de productos
      fetchProductos();
    } catch (error) {
      console.error("Error al agregar el producto:", error);
    }
  };

  const updateProducto = async (id: number, updatedProduct: ProductProviderDTO) => {
    try {
      const response = await fetch(`http://localhost:8086/api/v1/proveedor/${id}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(updatedProduct),
      });
  
      if (!response.ok) {
        throw new Error("Error al actualizar el producto");
      }
  
      // Actualizar la lista de productos
      fetchProductos();
    } catch (error) {
      console.error("Error al actualizar el producto:", error);
    }
  };

  return (
    <div className="container">
      <ProductList productos={productos} onAddProduct={addProducto} onUpdateProduct={updateProducto} />

    </div>
  );
};

export default PageProveedor;
