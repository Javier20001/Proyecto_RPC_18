import React, { useState } from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { Button } from "@mui/material";
import { ProductProviderDTO } from "../redux/types";
import "../pages/PageProveedor.css";
import AddProductForm from "./AddProductForm";
import EditProductForm from "./EditProductForm";



interface ProductListProps {
  productos: ProductProviderDTO[];
  onAddProduct: (product: ProductProviderDTO) => void; // Agrega la prop para manejar la adición
  onUpdateProduct: (id: number, updatedProduct: ProductProviderDTO) => void; // Nueva prop para actualizar
}

const ProductList: React.FC<ProductListProps> = ({ productos, onAddProduct, onUpdateProduct }) => {
  const [open, setOpen] = useState(false);
  const [openEdit, setOpenEdit] = useState(false);
  const [selectedProduct, setSelectedProduct] = useState<ProductProviderDTO | null>(null);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleEditClick = (producto: ProductProviderDTO) => {
    setSelectedProduct(producto); // Almacena el producto seleccionado
    setOpenEdit(true); // Abre el formulario de edición
  };

  const handleEditClose = () => {
    setOpenEdit(false);
    setSelectedProduct(null); // Limpia el producto seleccionado
  };

  return (
    <div className="product-list">
      <h1>Lista de Productos</h1>

      <div style={{ display: 'flex', justifyContent: 'center', width: '100%', margin: '20px 0' }}>
        <Button
          variant="contained"
          color="primary"
          onClick={handleClickOpen}
        >
          Agregar Producto
        </Button>
      </div>

      <AddProductForm
        open={open}
        onClose={handleClose}
        onAddProduct={onAddProduct} // Pasa la función de agregar producto
      />

      <TableContainer component={Paper} style={{ width: '100%', margin: '0 auto' }}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell align="center">ID</TableCell>
              <TableCell align="center">Código</TableCell>
              <TableCell align="center">Color</TableCell>
              <TableCell align="center">Talle</TableCell>
              <TableCell align="center">Stock</TableCell>
              <TableCell align="center">Foto</TableCell>
              <TableCell align="center">Acciones</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {productos.map((producto) => (
              <TableRow key={producto.id}>
                <TableCell align="center">{producto.id}</TableCell>
                <TableCell align="center">{producto.codigo}</TableCell>
                <TableCell align="center">{producto.color}</TableCell>
                <TableCell align="center">{producto.talle}</TableCell>
                <TableCell align="center">{producto.stock}</TableCell>
                <TableCell align="center">
                  <img
                    src={producto.foto}
                    alt={`Foto de ${producto.codigo}`}
                    width="50"
                    height="50"
                  />
                </TableCell>
                <TableCell align="center">
                  <Button variant="contained" color="primary" onClick={() => handleEditClick(producto)}>
                    Modificar
                  </Button>
                </TableCell>

              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
      {/* Modal de edición para actualizar stock y foto */}
      {selectedProduct && (
        <EditProductForm
          open={openEdit}
          onClose={handleEditClose}
          product={selectedProduct}
          onUpdateProduct={onUpdateProduct}
        />
      )}
    </div>
  );
};

export default ProductList;
