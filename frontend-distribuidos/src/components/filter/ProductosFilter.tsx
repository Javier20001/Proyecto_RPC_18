import { TextField } from "@mui/material";
import { ChangeEvent, useState } from "react";
import { filterProductoTiendaDTO } from "../../redux/types";
import { useProductoEnTiendaContext } from "../../hooks/ProductContext";
import "./ProductoFilteCss.css";
import useAuthContext from "../../hooks/AuthContext";

const ProductosFilter: React.FC = () => {
  const { filter_Productos } = useProductoEnTiendaContext();
  const { rol } = useAuthContext();
  const [formData, setFormData] = useState<filterProductoTiendaDTO>({
    nombre: "",
    codigo: "",
    talle: "",
    color: "",
    tienda_id: 0,
  });

  const handleInputChange = (event: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSearch = (event: React.FormEvent) => {
    event.preventDefault();
    filter_Productos(formData);
    setFormData({
      nombre: "",
      codigo: "",
      talle: "",
      color: "",
      tienda_id: 0,
    });
  };

  return (
    <div className="formFilter">
      <form onSubmit={handleSearch} className="form-container">
        <TextField
          fullWidth
          label="nombre"
          name="nombre"
          value={formData.nombre}
          onChange={handleInputChange}
          margin="normal"
        />
        <TextField
          fullWidth
          label="codigo"
          name="codigo"
          value={formData.codigo}
          onChange={handleInputChange}
          margin="normal"
        />
        <TextField
          fullWidth
          label="color"
          name="color"
          value={formData.color}
          onChange={handleInputChange}
          margin="normal"
        />
        <TextField
          fullWidth
          label="talle"
          name="talle"
          value={formData.talle}
          onChange={handleInputChange}
          margin="normal"
        />
        {rol == "admin" && (
          <TextField
            fullWidth
            label="ID Tienda"
            name="tienda_id"
            value={formData.tienda_id}
            onChange={handleInputChange}
            margin="normal"
          />
        )}
        <button type="submit" className="edit-button">
          buscar producto
        </button>
      </form>
    </div>
  );
};

export default ProductosFilter;
