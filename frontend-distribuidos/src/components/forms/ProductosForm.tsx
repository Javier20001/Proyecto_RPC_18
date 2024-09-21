import React, { useState, ChangeEvent } from "react";
import { TextField } from "@mui/material";
import { useProductoEnTiendaContext } from "../../hooks/ProductContext";
import { ProductoEnTienda, ProductoEnTiendaDTO } from "../../redux/types";

interface FormProductoEnTiendaProps {
  handleClose: () => void;
  productoEnTienda?: ProductoEnTienda;
}

const FormProductoEnTienda: React.FC<FormProductoEnTiendaProps> = ({
  handleClose,
  productoEnTienda,
}) => {
  const { add_Producto, update_Producto } = useProductoEnTiendaContext();

  const [formData, setFormData] = useState<ProductoEnTiendaDTO>({
    nombre: productoEnTienda?.producto.nombre || "",
    codigo: productoEnTienda?.producto.codigo || "",
    foto: productoEnTienda?.producto.foto || "",
    talle: productoEnTienda?.talle || "",
    color: productoEnTienda?.color || "",
  });

  const handleInputChange = (event: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = (event: React.FormEvent) => {
    event.preventDefault();

    if (productoEnTienda) {
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
    </form>
  );
};

export default FormProductoEnTienda;
