import React, { useState } from "react";
import {
  Modal,
  Typography,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  Button,
  TextField,
} from "@mui/material";
import { useProductoEnTiendaContext } from "../../hooks/ProductContext";
import { ProductoEnOCModel } from "../../redux/types";
import useAuthContext from "../../hooks/AuthContext";

interface ModalProductosDeOrdenTiendaProps {
  onProductsSelect: (selectedProducts: ProductoEnOCModel[]) => void;
}

const ModalProductosDeOrdenTienda: React.FC<
  ModalProductosDeOrdenTiendaProps
> = ({ onProductsSelect }) => {
  const { idTienda } = useAuthContext();
  const [open, setOpen] = useState(false);
  const { filter_Productos_By_Tienda } = useProductoEnTiendaContext();
  const [selectedProducts, setSelectedProducts] = useState<ProductoEnOCModel[]>(
    []
  );
  const [productStock, setProductStock] = useState<{ [key: number]: number }>(
    {}
  );

  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  const productosFiltrados = filter_Productos_By_Tienda(idTienda);

  const handleStockChange = (productId: number, stock: number) => {
    setProductStock({ ...productStock, [productId]: stock });
  };

  const handleAddProduct = (product: any) => {
    const stock = productStock[product.id] || 0;
    if (stock > 0) {
      const newProduct: ProductoEnOCModel = {
        id: product.id,
        codigo: product.producto.codigo,
        color: product.color,
        talle: product.talle,
        cantidadSolicitada: stock,
      };
      setSelectedProducts([...selectedProducts, newProduct]);
    }
  };

  const handleConfirmSelection = () => {
    onProductsSelect(selectedProducts);
    handleClose();
  };

  return (
    <div>
      <Button onClick={handleOpen} variant="contained" color="primary">
        Agregar productos a la orden
      </Button>
      <Modal open={open} onClose={handleClose}>
        <div className="modal-content">
          <Typography variant="h6">Productos en la Tienda</Typography>
          <TableContainer component={Paper}>
            {productosFiltrados.length > 0 ? (
              <Table>
                <TableHead>
                  <TableRow>
                    <TableCell>Código</TableCell>
                    <TableCell>Nombre</TableCell>
                    <TableCell>Talle</TableCell>
                    <TableCell>Color</TableCell>
                    <TableCell>Cantidad</TableCell>
                    <TableCell>Acciones</TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {productosFiltrados.map((product) => (
                    <TableRow key={product.id}>
                      <TableCell>{product.producto.codigo}</TableCell>
                      <TableCell>{product.producto.nombre}</TableCell>
                      <TableCell>{product.talle}</TableCell>
                      <TableCell>{product.color}</TableCell>
                      <TableCell>
                        <TextField
                          type="number"
                          value={productStock[product.id] || ""}
                          onChange={(e) =>
                            handleStockChange(
                              product.id,
                              parseInt(e.target.value, 10)
                            )
                          }
                        />
                      </TableCell>
                      <TableCell>
                        <Button
                          onClick={() => handleAddProduct(product)}
                          variant="contained"
                          color="primary"
                        >
                          Agregar
                        </Button>
                      </TableCell>
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
            ) : (
              <Typography>No hay productos en la tienda.</Typography>
            )}
          </TableContainer>
          <Button
            onClick={handleConfirmSelection}
            variant="contained"
            color="primary"
          >
            Confirmar Selección
          </Button>
        </div>
      </Modal>
    </div>
  );
};

export default ModalProductosDeOrdenTienda;
