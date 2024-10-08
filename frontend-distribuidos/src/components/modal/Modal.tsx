import React from "react";

import { Modal, Typography } from "@mui/material";
import "./Modal.css";
import FormStore from "../forms/StoreForm";
import { ProductoEnTienda, Tienda, User } from "../../redux/types";
import FormProductoEnTienda from "../forms/ProductosForm";
import UserForm from "../forms/UserForm";

interface modalProps {
  titulo: string;
  proveniencia: string;
  tienda?: Tienda;
  producto?: ProductoEnTienda;
  user?: User;
}

const BasicModal: React.FC<modalProps> = ({
  titulo,
  tienda,
  proveniencia,
  producto,
  user,
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

          {proveniencia === "user" && (
            <UserForm user={user} handleClose={handleClose} />
          )}
        </div>
      </Modal>
    </div>
  );
};

export default BasicModal;