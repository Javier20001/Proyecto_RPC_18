import React, { useState } from "react";
import { Dialog, DialogTitle, DialogContent, DialogActions, Button, TextField } from "@mui/material";
import { ProductProviderDTO } from "../redux/types";

interface EditProductFormProps {
  open: boolean;
  onClose: () => void;
  product: ProductProviderDTO;
  onUpdateProduct: (id: number, updatedProduct: ProductProviderDTO) => void;
}

const EditProductForm: React.FC<EditProductFormProps> = ({ open, onClose, product, onUpdateProduct }) => {
  const [stock, setStock] = useState(product.stock);
  const [foto, setFoto] = useState(product.foto);
  const [error, setError] = useState(""); // Estado para manejar el mensaje de error

  const handleSave = () => {
    if (stock < 0) {
      setError("El stock no puede ser negativo.");
      return;
    }
    
    const updatedProduct = { ...product, stock, foto }; // Solo actualizamos stock y foto
    onUpdateProduct(product.id, updatedProduct); // Llama a la función para actualizar el producto
    onClose(); // Cierra el modal
  };

  const handleStockChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const value = parseInt(e.target.value);
    if (value < 0) {
      setError("El stock no puede ser negativo.");
    } else {
      setError("");
      setStock(value);
    }
  };

  return (
    <Dialog open={open} onClose={onClose}>
      <DialogTitle>Modificar Producto</DialogTitle>
      <DialogContent>
        <TextField
          margin="dense"
          label="Stock"
          type="number"
          fullWidth
          value={stock}
          onChange={handleStockChange}
          error={!!error} // Marca el campo como erróneo si hay un mensaje de error
          helperText={error} // Muestra el mensaje de error
        />
        <TextField
          margin="dense"
          label="Foto"
          type="text"
          fullWidth
          value={foto}
          onChange={(e) => setFoto(e.target.value)}
        />
      </DialogContent>
      <DialogActions>
        <Button onClick={onClose} color="primary">Cancelar</Button>
        <Button onClick={handleSave} color="primary" disabled={!!error}>Guardar</Button>
      </DialogActions>
    </Dialog>
  );
};

export default EditProductForm;
