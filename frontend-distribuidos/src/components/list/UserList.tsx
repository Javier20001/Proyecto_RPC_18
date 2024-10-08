import React from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { useUserContext } from "../../hooks/UserContext";
import BasicModal from "../modal/Modal";

const UserList: React.FC = () => {
  const { users } = useUserContext();

  return (
    <div>
      <BasicModal proveniencia="user" titulo="Agregar" />
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>ID</TableCell>
              <TableCell>nombre</TableCell>
              <TableCell>apellido</TableCell>
              <TableCell>tiendaID</TableCell>
              <TableCell>rol</TableCell>
              <TableCell>accion</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {users.map((user) => (
              <TableRow
                key={user.id}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell scope="row">{user.id}</TableCell>
                <TableCell scope="row">{user.nombre}</TableCell>
                <TableCell scope="row">{user.apellido}</TableCell>
                <TableCell scope="row">{user.tiendaID}</TableCell>
                <TableCell scope="row">{user.rol}</TableCell>
                <BasicModal
                  proveniencia="user"
                  titulo="Actualizar"
                  user={user}
                />
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );
};

export default UserList;
