import React, { ChangeEvent, useState } from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { useUserContext } from "../../hooks/UserContext";
import BasicModal from "../modal/Modal";
import { TextField } from "@mui/material";

const UserList: React.FC = () => {
  const { users, find_User_By_Username, fetch_all_user, find_Users_By_Tienda } =
    useUserContext();
  const [userName, setUserName] = useState<string>("");
  const [tiendaId, setTiendaId] = useState<string>("");

  const handlefilterUsername = (event: ChangeEvent<HTMLInputElement>) => {
    setUserName(String(event.target.value));
  };

  const handlefilterIDTienda = (event: ChangeEvent<HTMLInputElement>) => {
    setTiendaId(String(event.target.value));
  };

  const handleSearch = (event: React.FormEvent) => {
    event.preventDefault();
    if (userName) {
      find_User_By_Username(userName);
    } else if (tiendaId) {
      find_Users_By_Tienda(Number(tiendaId));
    } else {
      fetch_all_user();
    }
    setUserName("");
    setTiendaId("");
  };

  return (
    <div>
      <div>
        <form onSubmit={handleSearch} className="form-container">
          <TextField
            fullWidth
            label="UserName"
            name="UserName"
            value={userName}
            onChange={handlefilterUsername}
            margin="normal"
          />
          <TextField
            fullWidth
            label="ID Tienda"
            name="ID Tienda"
            value={tiendaId}
            onChange={handlefilterIDTienda}
            margin="normal"
          />
          <button type="submit" className="edit-button">
            buscar usuario
          </button>
        </form>
      </div>
      <BasicModal proveniencia="user" titulo="Agregar" />
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>ID</TableCell>
              <TableCell>username</TableCell>
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
                <TableCell scope="row">{user.username}</TableCell>
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
