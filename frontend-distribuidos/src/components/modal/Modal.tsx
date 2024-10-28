import React from "react";

import { Modal, Typography } from "@mui/material";
import "./Modal.css";
import FormStore from "../forms/StoreForm";
import { Filtro, ProductoEnTienda, Tienda, User } from "../../redux/types";
import FormProductoEnTienda from "../forms/ProductosForm";
import UserForm from "../forms/UserForm";
import PurchaseOrderForm from "../forms/PurchaseOrderForm";
import PurchaseOrderFilter from "../filter/PurchaseOrderFilter";

interface modalProps {
  titulo: string;
  proveniencia: string;
  tienda?: Tienda;
  producto?: ProductoEnTienda;
  user?: User;
  filtro?: Filtro;
}

const BasicModal: React.FC<modalProps> = ({
  titulo,
  tienda,
  proveniencia,
  producto,
  user,
  filtro,
}) => {
  const [open, setOpen] = React.useState(false);

  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  return (
    <div>
      <button onClick={handleOpen}>{titulo}</button>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <div className="modal-content">
          <Typography id="modal-modal-title" variant="h6" component="h2">
            {titulo}
          </Typography>
          {proveniencia === "tienda" && (
            <FormStore handleClose={handleClose} tienda={tienda} />
          )}

          {proveniencia === "producto" && (
            <FormProductoEnTienda
              productoEnTienda={producto}
              handleClose={handleClose}
            />
          )}

          {proveniencia === "ordenDeCompra" && (
            <PurchaseOrderForm handleClose={handleClose} />
          )}

          {proveniencia === "Filtros" && (
            <PurchaseOrderFilter
              filtro={filtro}
              handleClose={handleClose}
              modal={true}
            />
          )}

          {proveniencia === "user" && (
            <UserForm user={user} handleClose={handleClose} />
          )}
        </div>
      </Modal>
    </div>
  );
};

export default BasicModal;
