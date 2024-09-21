import React from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { useStoreContext } from "../../hooks/StoreContext";
import BasicModal from "../modal/Modal";
import ModalProductosDeTienda from "../modal/ModalProductosDeTienda";

const StoreList: React.FC = () => {
  const { stores } = useStoreContext();

  return (
    <div>
      <BasicModal proveniencia="tienda" titulo="Agregar" />
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>ID</TableCell>
              <TableCell>codigo</TableCell>
              <TableCell>provincia</TableCell>
              <TableCell>ciudad</TableCell>
              <TableCell>Direccion</TableCell>
              <TableCell></TableCell>
              <TableCell>Acciones</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {stores.map((store) => (
              <TableRow
                key={store.id}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell scope="row">{store.id}</TableCell>
                <TableCell scope="row">{store.codigo}</TableCell>
                <TableCell>{store.provincia}</TableCell>
                <TableCell scope="row">{store.ciudad}</TableCell>
                <TableCell scope="row">{store.direccion}</TableCell>
                <TableCell>
                  <ModalProductosDeTienda tienda={store} />
                </TableCell>
                <TableCell>
                  <BasicModal
                    titulo="Actualizar"
                    proveniencia="tienda"
                    tienda={store}
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

export default StoreList;
