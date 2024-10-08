import React, { useState } from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { Button, ButtonBase } from "@mui/material";
import { ProductProviderDTO } from "../redux/types";
import "../pages/PageProveedor.css";
import AddProductForm from "./AddProductForm";



interface ProductListProps {
    productos: ProductProviderDTO[];
    onAddProduct: (product: ProductProviderDTO) => void; // Agrega la prop para manejar la adición
    onUpdateProduct: (id: number, updatedProduct: ProductProviderDTO) => void; // Nueva prop para actualizar
  }

  const ProductList: React.FC<ProductListProps> = ({ productos, onAddProduct, onUpdateProduct  }) => {
    const [open, setOpen] = useState(false);
    const [openEdit, setOpenEdit] = useState(false);
    const [selectedProduct, setSelectedProduct] = useState<ProductProviderDTO | null>(null);
  
    const handleClickOpen = () => {
      setOpen(true);
    };
  
    const handleClose = () => {
      setOpen(false);
    };

    const handleClickOpenEdit = (producto: ProductProviderDTO) => {
        setSelectedProduct(producto);
        setOpenEdit(true);
      };
    
      const handleCloseEdit = () => {
        setOpenEdit(false);
        setSelectedProduct(null);
      };
    
      const handleUpdate = () => {
        if (selectedProduct) {
          onUpdateProduct(selectedProduct.id, selectedProduct);
          handleCloseEdit();
        }
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
                <TableCell>ID</TableCell>
                <TableCell>Código</TableCell>
                <TableCell>Color</TableCell>
                <TableCell>Talle</TableCell>
                <TableCell>Stock</TableCell>
                <TableCell>Foto</TableCell>
                <TableCell>Acciones</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {productos.map((producto) => (
                <TableRow key={producto.id}>
                  <TableCell>{producto.id}</TableCell>
                  <TableCell>{producto.codigo}</TableCell>
                  <TableCell>{producto.color}</TableCell>
                  <TableCell>{producto.talle}</TableCell>
                  <TableCell>{producto.stock}</TableCell>
                  <TableCell>
                    <img
                      src={producto.foto}
                      alt={`Foto de ${producto.codigo}`}
                      width="50"
                      height="50"
                    />
                  </TableCell>
                  
                  <TableCell>
                  
                </TableCell>
                
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </div>
    );
  };

export default ProductList;
