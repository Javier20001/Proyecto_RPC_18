import React from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { useFilterContext } from "../../hooks/FilterContext";
import BasicModal from "../modal/Modal";

const Filtroslist: React.FC = () => {
  const { filtros, eliminarFiltro } = useFilterContext();

  const handleDelete = (id: number) => {
    eliminarFiltro(id);
  };

  return (
    <div>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>ID</TableCell>
              <TableCell>Fecha Fin</TableCell>
              <TableCell>Fecha Inicio</TableCell>
              <TableCell>Nombre</TableCell>
              <TableCell>Acción</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {filtros.map((filtro) => (
              <TableRow
                key={filtro.id}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell scope="row">{filtro.id}</TableCell>
                <TableCell scope="row">{filtro.fechaFin}</TableCell>
                <TableCell scope="row">{filtro.fechaInicio}</TableCell>
                <TableCell scope="row">{filtro.nombre}</TableCell>
                {filtro.habilitado && (
                  <TableCell>
                    <BasicModal
                      titulo="Actualizar"
                      proveniencia="Filtros"
                      filtro={filtro}
                    />
                    <button
                      type="button"
                      className="save-button"
                      onClick={() => handleDelete(filtro.id)}
                    >
                      Eliminar
                    </button>
                  </TableCell>
                )}
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );
};

export default Filtroslist;
