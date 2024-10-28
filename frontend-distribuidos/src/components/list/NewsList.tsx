import React from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { useNewsContext } from "../../hooks/NewsContext";
import { Button } from "@mui/material";

const NewsList: React.FC = () => {
  const { novedades, dar_De_Alta_Novedad } = useNewsContext();

  const handleAddProduct = (id: number) => {
    dar_De_Alta_Novedad(id);
  };

  return (
    <div>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>ID</TableCell>
              <TableCell>Talle</TableCell>
              <TableCell>Codigo</TableCell>
              <TableCell>Foto</TableCell>
              <TableCell>Accion</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {novedades.map((novedad) => (
              <TableRow
                key={novedad.id}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell scope="row">{novedad.id}</TableCell>
                <TableCell scope="row">{novedad.talle}</TableCell>
                <TableCell scope="row">{novedad.codigo}</TableCell>
                <TableCell>
                  <img
                    src={novedad.foto}
                    alt={`Foto de ${novedad.codigo}`}
                    width="50"
                    height="50"
                  />
                </TableCell>
                <TableCell>
                  <Button
                    onClick={() => handleAddProduct(novedad.id)}
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
      </TableContainer>
    </div>
  );
};

export default NewsList;
