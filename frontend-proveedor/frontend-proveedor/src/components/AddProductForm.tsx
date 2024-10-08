import React from 'react';
import { Dialog, DialogActions, DialogContent, DialogTitle, TextField, Button, Select, MenuItem, FormControl, InputLabel } from "@mui/material";

interface AddProductFormProps {
  open: boolean;
  onClose: () => void;
  onAddProduct: (productData: any) => void; // Puedes definir una interfaz para los datos del producto
}

const AddProductForm: React.FC<AddProductFormProps> = ({ open, onClose, onAddProduct }) => {
  const [codigo, setCodigo] = React.useState('');
  const [color, setColor] = React.useState('');
  const [talle, setTalle] = React.useState('');
  const [stock, setStock] = React.useState<number | ''>(''); 
  const [foto, setFoto] = React.useState('');

  const handleSubmit = () => {
    // Validaciones
    if (!codigo || !color || !talle) {
      alert("Por favor, completa todos los campos (Código, Color, Talle).");
      return;
    }

    const stockValue = typeof stock === 'number' ? stock : 0;
    if (stockValue <= 0) {
      alert("El stock debe ser mayor a 0.");
      return;
    }

    if (codigo.length > 10) {
      alert("El código no puede superar los 10 caracteres.");
      return;
    }

    const productData = {
      codigo,
      color,
      talle,
      stock: stockValue,
      foto: foto.trim() === '' ? null : foto, // Enviar null si foto está vacía
    };

    onAddProduct(productData); // Llama a la función para agregar el producto
    clearFields(); // Limpia los campos después de agregar
    onClose();
  };

  const clearFields = () => {
    setCodigo('');
    setColor('');
    setTalle('');
    setStock('');
    setFoto('');
  };

  return (
    <Dialog open={open} onClose={onClose}>
      <DialogTitle>Agregar Nuevo Producto</DialogTitle>
      <DialogContent>
        <TextField
          autoFocus
          margin="dense"
          label="Código"
          fullWidth
          variant="outlined"
          value={codigo}
          onChange={(e) => setCodigo(e.target.value)}
          error={codigo.length > 10}
          helperText={codigo.length > 10 ? "El código no puede superar los 10 caracteres." : ""}
        />
        <TextField
          margin="dense"
          label="Color"
          fullWidth
          variant="outlined"
          value={color}
          onChange={(e) => setColor(e.target.value)}
        />
        <FormControl fullWidth margin="dense">
          <InputLabel>Talle</InputLabel>
          <Select
            value={talle}
            onChange={(e) => setTalle(e.target.value)}
            label="Talle"
          >
            <MenuItem value="S">S</MenuItem>
            <MenuItem value="M">M</MenuItem>
            <MenuItem value="L">L</MenuItem>
            <MenuItem value="XL">XL</MenuItem>
            <MenuItem value="XXL">XXL</MenuItem>
          </Select>
        </FormControl>
        <TextField
          margin="dense"
          label="Stock"
          fullWidth
          variant="outlined"
          type="number"
          value={stock}
          onChange={(e) => setStock(Number(e.target.value))}
        />
        <TextField
          margin="dense"
          label="Foto URL"
          fullWidth
          variant="outlined"
          value={foto}
          onChange={(e) => setFoto(e.target.value)}
        />
      </DialogContent>
      <DialogActions>
        <Button onClick={onClose} color="primary">
          Cancelar
        </Button>
        <Button onClick={handleSubmit} color="primary">
          Agregar
        </Button>
      </DialogActions>
    </Dialog>
  );
};

export default AddProductForm;
