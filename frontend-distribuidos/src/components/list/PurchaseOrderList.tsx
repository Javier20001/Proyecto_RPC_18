import React from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { useOrdenDeCompraContext } from "../../hooks/PurchaseOrderContext";
import useAuthContext from "../../hooks/AuthContext";
import { Button } from "@mui/material";

const PurchaseOrderList: React.FC = () => {
  const { ordenesDeCompra, receiveOrden } = useOrdenDeCompraContext();
  const { idTienda, rol } = useAuthContext();

  const handleAddProduct = (id: number) => {
    receiveOrden(idTienda, id);
  };

  return (
    <div>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>ID</TableCell>
              <TableCell>Estado</TableCell>
              <TableCell>Fecha De Solicitud</TableCell>
              <TableCell>Observaciones</TableCell>
              <TableCell></TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {ordenesDeCompra.length === 0 ? (
              <TableRow>
                <TableCell colSpan={5} align="center">
                  No hay órdenes de compra
                </TableCell>
              </TableRow>
            ) : (
              ordenesDeCompra.map((order) => (
                <TableRow
                  key={order.id}
                  sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
                >
                  <TableCell scope="row">{order.id}</TableCell>
                  <TableCell scope="row">{order.estado}</TableCell>
                  <TableCell scope="row">{order.fechaDeSolicitud}</TableCell>
                  <TableCell scope="row">{order.observaciones}</TableCell>
                  {/* <TableCell scope="row">{order.tiendaId}</TableCell> */}
                  {rol === "user" && order.estado === "ACEPTADA" && (
                    <TableCell>
                      <Button
                        onClick={() => handleAddProduct(order.id)}
                        variant="contained"
                        color="primary"
                      >
                        Recibido
                      </Button>
                    </TableCell>
                  )}
                </TableRow>
              ))
            )}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );
};

export default PurchaseOrderList;
