import React, { useState, ChangeEvent } from "react";
import { TextField, Button } from "@mui/material";
import StoreSelectionModal from "../modal/ModalAsignarTienda"; // El modal que acabamos de crear
import { useUserContext } from "../../hooks/UserContext"; // Asegúrate de tener el contexto configurado
import { User, UserDTO } from "../../redux/types"; // Asegúrate de tener definidos los tipos
import {
  userValidationWithoutPassword,
  userValidationWithPassword,
  ValidationErrors,
} from "../../funcionalities/validations"; // Valida los campos

interface FormUserProps {
  user?: User;
  handleClose: () => void;
}

const UserForm: React.FC<FormUserProps> = ({ user, handleClose }) => {
  const { create_User, modify_User } = useUserContext();
  const [formData, setFormData] = useState({
    password: user?.password || "",
    username: user?.username || "",
    nombre: user?.nombre || "",
    apellido: user?.apellido || "",
    tienda_id: user?.tiendaID || 1,
  });

  const [errors, setErrors] = useState<ValidationErrors>({});
  const [isStoreModalOpen, setIsStoreModalOpen] = useState(false);

  const handleInputChange = (event: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = (event: React.FormEvent) => {
    event.preventDefault();

    const validationErrors: ValidationErrors = {};
    if (user) {
      userValidationWithPassword(
        formData.apellido,
        formData.nombre,
        formData.username
      );
    } else {
      userValidationWithoutPassword(
        formData.apellido,
        formData.nombre,
        formData.password,
        formData.username
      );
    }
    setErrors(validationErrors);

    if (Object.keys(validationErrors).length === 0) {
      const userdto: UserDTO = { ...formData };
      if (user) {
        modify_User(user.id, userdto);
      } else {
        console.log(userdto);
        create_User(userdto);
      }
      handleClose();
    }
  };

  const handleStoreSelect = (storeId: number) => {
    setFormData({ ...formData, tienda_id: storeId });
    setIsStoreModalOpen(false); // Cerrar el modal después de seleccionar una tienda
  };

  return (
    <form onSubmit={handleSubmit} className="form-container">
      <TextField
        fullWidth
        label="Username"
        name="username"
        value={formData.username}
        onChange={handleInputChange}
        margin="normal"
        className="form-field"
        error={!!errors.username}
        helperText={errors.username}
      />
      {!user && (
        <TextField
          fullWidth
          label="Password"
          name="password"
          type="password"
          value={formData.password}
          onChange={handleInputChange}
          margin="normal"
          className="form-field"
          error={!!errors.password}
          helperText={errors.password}
        />
      )}
      <TextField
        fullWidth
        label="Nombre"
        name="nombre"
        value={formData.nombre}
        onChange={handleInputChange}
        margin="normal"
        className="form-field"
        error={!!errors.nombre}
        helperText={errors.nombre}
      />
      <TextField
        fullWidth
        label="Apellido"
        name="apellido"
        value={formData.apellido}
        onChange={handleInputChange}
        margin="normal"
        className="form-field"
        error={!!errors.apellido}
        helperText={errors.apellido}
      />
      <Button onClick={() => setIsStoreModalOpen(true)} variant="outlined">
        Asignar Tienda
      </Button>
      <p>Tienda Seleccionada: {formData.tienda_id}</p>

      <Button type="submit" variant="contained" color="primary">
        {user ? "Actualizar" : "Agregar"}
      </Button>

      <StoreSelectionModal
        open={isStoreModalOpen}
        onClose={() => setIsStoreModalOpen(false)}
        onSelectStore={handleStoreSelect}
      />
    </form>
  );
};

export default UserForm;
