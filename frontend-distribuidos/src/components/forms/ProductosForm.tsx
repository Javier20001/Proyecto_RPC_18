import React, { useState, ChangeEvent } from "react";
import { TextField } from "@mui/material";
import { useProductoEnTiendaContext } from "../../hooks/ProductContext";
import {
  ProductoEnTienda,
  ProductoEnTiendaDTO,
  updatProductStock,
} from "../../redux/types";
import useAuthContext from "../../hooks/AuthContext";

interface FormProductoEnTiendaProps {
  handleClose: () => void;
  productoEnTienda?: ProductoEnTienda;
}

const FormProductoEnTienda: React.FC<FormProductoEnTiendaProps> = ({
  handleClose,
  productoEnTienda,
}) => {
  const { add_Producto, update_Producto, update_Stock } =
    useProductoEnTiendaContext();
  const { rol } = useAuthContext();
  const [formData, setFormData] = useState<ProductoEnTiendaDTO>({
    producto_id: productoEnTienda?.id,
    nombre: productoEnTienda?.producto.nombre || "",
    codigo: productoEnTienda?.producto.codigo || "",
    foto: productoEnTienda?.producto.foto || "",
    talle: productoEnTienda?.talle || "",
    color: productoEnTienda?.color || "",
  });

  const [stock, setStock] = useState<number>(productoEnTienda?.stock ?? 0);

  const handleInputChange = (event: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleStockChange = (event: ChangeEvent<HTMLInputElement>) => {
    setStock(Number(event.target.value));
  };

  const handleSubmit = (event: React.FormEvent) => {
    event.preventDefault();

    if (rol === "user" && productoEnTienda && productoEnTienda.tienda) {
      const stockData: updatProductStock = {
        producto_id: productoEnTienda.id,
        tienda_id: productoEnTienda.tienda?.id,
        stock: stock,
        talle: formData.talle,
        color: formData.color,
      };
      update_Stock(stockData);
    } else if (productoEnTienda) {
      update_Producto(formData);
    } else {
      add_Producto(formData);
    }

    setFormData({
      nombre: "",
      codigo: "",
      foto: "",
      talle: "",
      color: "",
    });

    handleClose();
  };

  return (
    <form onSubmit={handleSubmit} className="form-container">
      {rol === "user" ? (
        <>
          <TextField
            fullWidth
            label="Stock"
            name="stock"
            value={stock}
            onChange={handleStockChange}
            margin="normal"
          />
          <button type="submit" className="edit-button">
            Actualizar Stock
          </button>
        </>
      ) : (
        <>
          <TextField
            fullWidth
            label="Nombre"
            name="nombre"
            value={formData.nombre}
            onChange={handleInputChange}
            margin="normal"
          />
          <TextField
            fullWidth
            label="Código"
            name="codigo"
            value={formData.codigo}
            onChange={handleInputChange}
            margin="normal"
          />
          <TextField
            fullWidth
            label="Foto (URL)"
            name="foto"
            value={formData.foto}
            onChange={handleInputChange}
            margin="normal"
          />
          <TextField
            fullWidth
            label="Talle"
            name="talle"
            value={formData.talle}
            onChange={handleInputChange}
            margin="normal"
          />
          <TextField
            fullWidth
            label="Color"
            name="color"
            value={formData.color}
            onChange={handleInputChange}
            margin="normal"
          />
          <button
            type="submit"
            className={productoEnTienda ? "edit-button" : "add-button"}
          >
            {productoEnTienda ? "Actualizar" : "Agregar"}
          </button>
        </>
      )}
    </form>
  );
};

export default FormProductoEnTienda;
