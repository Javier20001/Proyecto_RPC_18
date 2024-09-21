import React, { useState, ChangeEvent, useEffect } from "react";
import { TextField } from "@mui/material";
import { useDispatch } from "react-redux";
import { AppDispatch } from "../../redux/store/store";
import {
  storeValidation,
  ValidationErrors,
} from "../../funcionalities/validations";
import { Tienda } from "../../redux/types";
import { useStoreContext } from "../../hooks/StoreContext";

interface FormStoreProps {
  tienda?: Tienda;
  handleClose: () => void;
}

const FormStore: React.FC<FormStoreProps> = ({ handleClose, tienda }) => {
  const { add_Store, update_Store, delete_Store } = useStoreContext();
  const [formData, setFormData] = useState({
    codigo: tienda?.codigo || "",
    provincia: tienda?.provincia || "",
    ciudad: tienda?.ciudad || "",
    direccion: tienda?.direccion || "",
  });

  const [errors, setErrors] = useState<ValidationErrors>({});
  const dispatch = useDispatch<AppDispatch>();

  useEffect(() => {
    // Si necesitas despachar alguna acción para obtener datos adicionales, como ubicaciones, etc.
  }, [dispatch]);

  const handleInputChange = (event: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = async (event: React.FormEvent) => {
    const validationErrors = storeValidation(
      formData.provincia,
      formData.ciudad,
      formData.direccion
    );
    setErrors(validationErrors);

    event.preventDefault();
    if (Object.keys(validationErrors).length === 0) {
      const storedto = {
        ...formData,
      };

      if (tienda) {
        console.log(tienda.id);
        update_Store(storedto, tienda.id);
      } else {
        add_Store(storedto);
      }

      setFormData({
        codigo: "",
        provincia: "",
        ciudad: "",
        direccion: "",
      });

      handleClose();
    }
  };

  const handleDelete = async (tiendaID: number) => {
    if (tienda) {
      delete_Store(tiendaID);
      handleClose();
    }
  };

  return (
    <form onSubmit={handleSubmit} className="form-container">
      <TextField
        fullWidth
        label="codigo"
        name="codigo"
        value={formData.codigo}
        onChange={handleInputChange}
        margin="normal"
        className="form-field"
      />
      <TextField
        fullWidth
        label="Provincia"
        name="provincia"
        value={formData.provincia}
        onChange={handleInputChange}
        margin="normal"
        error={!!errors.provincia}
        helperText={errors.provincia}
        className="form-field"
      />
      <TextField
        fullWidth
        label="Ciudad"
        name="ciudad"
        value={formData.ciudad}
        onChange={handleInputChange}
        margin="normal"
        error={!!errors.ciudad}
        helperText={errors.ciudad}
        className="form-field"
      />
      <TextField
        fullWidth
        label="Dirección"
        name="direccion"
        value={formData.direccion}
        onChange={handleInputChange}
        margin="normal"
        error={!!errors.dirección}
        helperText={errors.dirección}
        className="form-field"
      />
      <button type="submit" className={tienda ? "edit-button" : "add-button"}>
        {tienda ? "Actualizar" : "Agregar"}
      </button>

      {tienda && (
        <button
          className="delete-button"
          onClick={() => handleDelete(tienda.id)}
        >
          Borrar
        </button>
      )}
    </form>
  );
};

export default FormStore;
