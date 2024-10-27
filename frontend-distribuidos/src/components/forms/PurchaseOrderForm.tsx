import React, { useState, ChangeEvent } from "react";
import { TextField, Button } from "@mui/material";
import ProductsSelectionModal from "../modal/ModalProductoOrdenCompra";
import { OrdenDeCompraModel, ProductoEnOCModel } from "../../redux/types";
import { useOrdenDeCompraContext } from "../../hooks/PurchaseOrderContext";
import useAuthContext from "../../hooks/AuthContext";

interface FormOrdenDeCompraProps {
  handleClose: () => void;
}

const PurchaseOrderForm: React.FC<FormOrdenDeCompraProps> = ({
  handleClose,
}) => {
  const { idTienda } = useAuthContext();
  const { createOrdenDeCompra } = useOrdenDeCompraContext();
  const [formData, setFormData] = useState<OrdenDeCompraModel>({
    id: 1,
    estado: "",
    observaciones: "",
    productosEnOC: [],
    tiendaId: 1,
    ordenDeDespachoId: idTienda,
    fechaDeSolicitud: "",
    fechaDeRecepcion: "",
    pausada: false,
  });

  // Nueva lista para gestionar productos con sus cantidades de stock
  const handleInputChange = (event: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = (event: React.FormEvent) => {
    event.preventDefault();
    // setFormData({ ...formData, productosEnOC: productosConStock });

    console.log(formData);
    createOrdenDeCompra(formData);
    handleClose();
  };

  // Manejar la selección de productos y la cantidad de stock
  const handleProductsSelect = (selectedProducts: ProductoEnOCModel[]) => {
    setFormData({ ...formData, productosEnOC: selectedProducts });
  };

  return (
    <form onSubmit={handleSubmit} className="form-container">
      <TextField
        fullWidth
        label="Estado"
        name="estado"
        value={formData.estado}
        onChange={handleInputChange}
        margin="normal"
        className="form-field"
      />
      <TextField
        fullWidth
        label="Observaciones"
        name="observaciones"
        value={formData.observaciones}
        onChange={handleInputChange}
        margin="normal"
      />
      <TextField
        fullWidth
        label="Fecha de Solicitud"
        name="fechaDeSolicitud"
        type="date"
        value={formData.fechaDeSolicitud}
        onChange={handleInputChange}
        margin="normal"
        className="form-field"
        InputLabelProps={{ shrink: true }}
      />
      <TextField
        fullWidth
        label="Fecha de Recepción"
        name="fechaDeRecepcion"
        type="date"
        value={formData.fechaDeRecepcion}
        onChange={handleInputChange}
        margin="normal"
        className="form-field"
        InputLabelProps={{ shrink: true }}
      />
      <p>Tienda Seleccionada: {formData.tiendaId}</p>

      {/* Modal para seleccionar productos y asignar stock */}
      <ProductsSelectionModal onProductsSelect={handleProductsSelect} />
      <p>Productos Seleccionados: {formData.productosEnOC.length}</p>

      <Button type="submit" variant="contained" color="primary">
        Agregar Orden
      </Button>
    </form>
  );
};

export default PurchaseOrderForm;
