import { Button, TextField } from "@mui/material";
import { ChangeEvent, useState } from "react";
import { FiltroAdd, Filtro, FiltroUpdate } from "../../redux/types";
import { useOrdenDeCompraContext } from "../../hooks/PurchaseOrderContext";
import useAuthContext from "../../hooks/AuthContext";
import { useFilterContext } from "../../hooks/FilterContext";
import { Link as RouterLink } from "react-router-dom";
import { formatDate } from "../../funcionalities/parseDate";

interface FormOrdenDeCompraProps {
  handleClose?: () => void;
  filtro?: Filtro;
  modal: boolean;
}

const PurchaseOrderFilter: React.FC<FormOrdenDeCompraProps> = ({
  handleClose,
  filtro,
  modal,
}) => {
  const { filtrarOrdenesDeCompra, getAllOrdenesDeCompra } =
    useOrdenDeCompraContext();

  const { agregarFiltro, actualizarFiltro, eliminarFiltro } =
    useFilterContext();
  const { rol, id } = useAuthContext();
  const [nombreFiltro, setNombreFiltro] = useState<string>(
    filtro?.nombre || ""
  );
  const [formData, setFormData] = useState({
    codigoProducto: filtro?.codigoProducto || "",
    fechaInicio: filtro?.fechaInicio ? formatDate(filtro.fechaInicio) : "",
    fechaFin: filtro?.fechaFin ? formatDate(filtro.fechaFin) : "",
    estado: filtro?.estado || "",
    tiendaId: filtro?.tiendaId || "",
  });

  const handleInputChange = (event: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;
    if (name === "nombreFiltro") {
      setNombreFiltro(value);
    }

    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSearch = (event: React.FormEvent) => {
    event.preventDefault();

    const isFormEmpty = Object.values(formData).every((value) => value === "");

    if (isFormEmpty) {
      getAllOrdenesDeCompra();
    } else {
      filtrarOrdenesDeCompra(formData);
    }

    setFormData({
      codigoProducto: "",
      fechaInicio: "",
      fechaFin: "",
      estado: "",
      tiendaId: "",
    });
    if (handleClose) {
      handleClose();
    }
  };

  const handleSaveFilter = (event: React.FormEvent) => {
    event.preventDefault();

    const isFormEmpty = Object.values(formData).every((value) => value === "");

    if (!isFormEmpty) {
      if (filtro) {
        const filtroUpdateData: FiltroUpdate = {
          ...formData,
          filtroId: filtro.id,
          nombre: nombreFiltro,
        };
        actualizarFiltro(filtroUpdateData);
      } else {
        const filtroAddData: FiltroAdd = {
          ...formData,
          usuarioId: id,
          nombre: nombreFiltro,
        };
        agregarFiltro(filtroAddData);
      }
      if (handleClose) {
        handleClose();
      }
    }

    setFormData({
      codigoProducto: "",
      fechaInicio: "",
      fechaFin: "",
      estado: "",
      tiendaId: "",
    });
  };

  return (
    <div className="formFilter">
      <form onSubmit={handleSearch} className="form-container">
        <TextField
          fullWidth
          label="Nombre del Filtro"
          name="nombreFiltro"
          value={nombreFiltro}
          onChange={handleInputChange}
          margin="normal"
        />
        <TextField
          fullWidth
          label="Código de Producto"
          name="codigoProducto"
          value={formData.codigoProducto}
          onChange={handleInputChange}
          margin="normal"
        />
        <TextField
          fullWidth
          label="Fecha de Inicio"
          name="fechaInicio"
          type="date"
          value={formData.fechaInicio}
          onChange={handleInputChange}
          margin="normal"
          InputLabelProps={{
            shrink: true,
          }}
        />
        <TextField
          fullWidth
          label="Fecha de Fin"
          name="fechaFin"
          type="date"
          value={formData.fechaFin}
          onChange={handleInputChange}
          margin="normal"
          InputLabelProps={{
            shrink: true,
          }}
        />
        <TextField
          fullWidth
          label="Estado"
          name="estado"
          value={formData.estado}
          onChange={handleInputChange}
          margin="normal"
        />
        {rol === "admin" && (
          <TextField
            fullWidth
            label="ID Tienda"
            name="tiendaId"
            value={formData.tiendaId}
            onChange={handleInputChange}
            margin="normal"
          />
        )}
        <div className="button-container">
          {!modal && (
            <div>
              <button type="submit" className="edit-button">
                Buscar Orden de Compra
              </button>
            </div>
          )}
          <button
            type="button"
            className="save-button"
            onClick={handleSaveFilter}
          >
            Guardar Filtro
          </button>
        </div>
      </form>
      {!modal && (
        <Button color="inherit" component={RouterLink} to="/MisFiltros">
          mis filtros
        </Button>
      )}
    </div>
  );
};

export default PurchaseOrderFilter;
