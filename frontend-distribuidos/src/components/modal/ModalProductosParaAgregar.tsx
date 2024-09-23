import React from "react";
import { Modal, Typography, Button } from "@mui/material";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { useProductoEnTiendaContext } from "../../hooks/ProductContext";
import {
  AsignarProductoEnTiendaDTO,
  ProductoEnTienda,
} from "../../redux/types";

interface modalProps {
  tienda_id: number;
}

const ModalProductosParaAgregar: React.FC<modalProps> = ({ tienda_id }) => {
  const [open, setOpen] = React.useState(false);
  const { productosEnTienda, assign_Producto } = useProductoEnTiendaContext();

  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  // Filtrar productos que no tienen un tienda.codigo asignado
  const productosSinTienda = productosEnTienda.filter(
    (product) => !product.tienda?.codigo
  );

  // Manejar la asignación de productos
  const handleAssign = (product: ProductoEnTienda) => {
    const data: AsignarProductoEnTiendaDTO = {
      producto_id: product.id,
      codigo: product.producto.codigo,
      foto: product.producto.foto,
      nombre: product.producto.nombre,
      color: product.color,
      talle: product.talle,
      tienda_id,
    };
    assign_Producto(data);
  };

  return (
    <div>
      <button onClick={handleOpen}>Ver productos sin tienda</button>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <div className="modal-content">
          <Typography id="modal-modal-title" variant="h6" component="h2">
            Productos sin tienda asignada
          </Typography>
          <TableContainer component={Paper}>
            <Table sx={{ minWidth: 650 }} aria-label="simple table">
              <TableHead>
                <TableRow>
                  <TableCell>codigo producto</TableCell>
                  <TableCell>nombre</TableCell>
                  <TableCell>talle</TableCell>
                  <TableCell>color</TableCell>
                  <TableCell>accion</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {productosSinTienda.map((product) => (
                  <TableRow
                    key={product.id_productoEnTienda}
                    sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
                  >
                    <TableCell scope="row">{product.producto.codigo}</TableCell>
                    <TableCell scope="row">{product.producto.nombre}</TableCell>
                    <TableCell>{product.talle}</TableCell>
                    <TableCell scope="row">{product.color}</TableCell>
                    <TableCell>
                      <Button
                        variant="contained"
                        color="primary"
                        onClick={() => handleAssign(product)}
                      >
                        Agregar
                      </Button>
                    </TableCell>
                  </TableRow>
                ))}
              </TableBody>
            </Table>
          </TableContainer>
          <Button variant="contained" color="primary" onClick={handleClose}>
            Cerrar
          </Button>
        </div>
      </Modal>
    </div>
  );
};

export default ModalProductosParaAgregar;
