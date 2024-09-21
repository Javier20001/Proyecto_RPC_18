import React from "react";
import { Modal, Typography } from "@mui/material";
import "./Modal.css";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { Tienda } from "../../redux/types";
import { useProductoEnTiendaContext } from "../../hooks/ProductContext";
import ModalProductosParaAgregar from "./ModalProductosParaAgregar";

interface modalProps {
  tienda: Tienda;
}

const ModalProductosDeTienda: React.FC<modalProps> = ({ tienda }) => {
  const [open, setOpen] = React.useState(false);
  const { productosEnTienda } = useProductoEnTiendaContext();

  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  // Filtrar productos que pertenezcan a la tienda con el mismo id
  const productosFiltrados = productosEnTienda.filter(
    (product) => product.tienda?.codigo === tienda?.id
  );

  return (
    <div>
      <button onClick={handleOpen}>Agregar productos</button>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <div className="modal-content">
          <Typography id="modal-modal-title" variant="h6" component="h2">
            Productos en esta Tienda
          </Typography>
          <TableContainer component={Paper}>
            {productosFiltrados.length > 0 ? (
              <Table sx={{ minWidth: 650 }} aria-label="simple table">
                <TableHead>
                  <TableRow>
                    <TableCell>codigo producto</TableCell>
                    <TableCell>nombre</TableCell>
                    <TableCell>talle</TableCell>
                    <TableCell>color</TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {productosFiltrados.map((product) => (
                    <TableRow
                      key={product.id_productoEnTienda}
                      sx={{
                        "&:last-child td, &:last-child th": { border: 0 },
                      }}
                    >
                      <TableCell>{product.producto.codigo}</TableCell>
                      <TableCell>{product.producto.nombre}</TableCell>
                      <TableCell>{product.talle}</TableCell>
                      <TableCell>{product.color}</TableCell>
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
            ) : (
              <Typography variant="body1">
                No hay productos en esta tienda.
              </Typography>
            )}
          </TableContainer>
          <ModalProductosParaAgregar tienda_id={tienda?.id} />
        </div>
      </Modal>
    </div>
  );
};

export default ModalProductosDeTienda;
