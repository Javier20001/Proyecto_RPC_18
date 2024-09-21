import React from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { useProductoEnTiendaContext } from "../../hooks/ProductContext";
import BasicModal from "../modal/Modal";

const ProductLis: React.FC = () => {
  const { productosEnTienda } = useProductoEnTiendaContext();

  console.log(productosEnTienda);
  return (
    <div>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>codigo</TableCell>
              <TableCell>
                codigo <br /> producto
              </TableCell>
              <TableCell>nombre</TableCell>
              <TableCell>talle</TableCell>
              <TableCell>color</TableCell>
              <TableCell>acciones</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {productosEnTienda.map((product) => (
              <TableRow
                key={product.id_productoEnTienda}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell scope="row">{product.id}</TableCell>
                <TableCell scope="row">
                  {
                    product.producto
                      .precio /* cambiar esto por codigo si no funciona*/
                  }
                </TableCell>
                <TableCell scope="row">{product.producto.nombre}</TableCell>
                <TableCell>{product.talle}</TableCell>
                <TableCell scope="row">{product.color}</TableCell>
                <TableCell>
                  <BasicModal
                    titulo="Actualizar"
                    proveniencia="producto"
                    producto={product}
                  />
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );
};

export default ProductLis;