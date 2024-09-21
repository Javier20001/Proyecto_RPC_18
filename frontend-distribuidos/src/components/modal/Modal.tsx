import React from "react";

import { Modal, Typography } from "@mui/material";
import "./Modal.css";
import FormStore from "../forms/StoreForm";
import { ProductoEnTienda, Tienda } from "../../redux/types";
import FormProductoEnTienda from "../forms/ProductosForm";

interface modalProps {
  titulo: string;
  proveniencia: string;
  tienda?: Tienda;
  producto?: ProductoEnTienda;
}

const BasicModal: React.FC<modalProps> = ({
  titulo,
  tienda,
  proveniencia,
  producto,
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
          <FormStore handleClose={handleClose} tienda={tienda} />
          {proveniencia === "producto" && (
            <FormProductoEnTienda
              productoEnTienda={producto}
              handleClose={handleClose}
            />
          )}
          {/* {proveniencia === "specialist" && (
            <FormSpecialist specialist={specialist} handleClose={handleClose} />
          )}
          {proveniencia === "schedules" && (
            <FormSchedule
              schedule={schedule}
              specialistID={specialistID ?? 0}
              handleClose={handleClose}
            />
          )}
          {proveniencia === "receta" && (
            <FormPrescription
              prescription={prescription}
              idShift={shiftID}
              handleClose={handleClose}
            />
          )}
          {proveniencia === "contacto" && <FormEmailSender />}

          {proveniencia === "servicios" && <FormServices />} */}
        </div>
      </Modal>
    </div>
  );
};

export default BasicModal;
