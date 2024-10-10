import React from "react";
import {
  Button,
  Modal,
  Box,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
} from "@mui/material";
import { useStoreContext } from "../../hooks/StoreContext"; // Asegúrate de tener este contexto configurado

interface StoreSelectionModalProps {
  open: boolean;
  onClose: () => void;
  onSelectStore: (storeId: number) => void;
}

const StoreSelectionModal: React.FC<StoreSelectionModalProps> = ({
  open,
  onClose,
  onSelectStore,
}) => {
  const { stores } = useStoreContext();

  return (
    <Modal open={open} onClose={onClose}>
      <Box
        sx={{
          width: 400,
          margin: "100px auto",
          padding: 2,
          backgroundColor: "white",
          borderRadius: 2,
        }}
      >
        <h2>Seleccionar Tienda</h2>
        <TableContainer component={Paper}>
          <Table>
            <TableHead>
              <TableRow>
                <TableCell>ID</TableCell>
                <TableCell>Codigo</TableCell>
                <TableCell>Provincia</TableCell>
                <TableCell>Ciudad</TableCell>
                <TableCell>Acciones</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {stores.map((store) => (
                <TableRow key={store.id}>
                  <TableCell>{store.id}</TableCell>
                  <TableCell>{store.codigo}</TableCell>
                  <TableCell>{store.provincia}</TableCell>
                  <TableCell>{store.ciudad}</TableCell>
                  <TableCell>
                    <Button onClick={() => onSelectStore(store.id)}>
                      Asignar
                    </Button>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </Box>
    </Modal>
  );
};

export default StoreSelectionModal;
