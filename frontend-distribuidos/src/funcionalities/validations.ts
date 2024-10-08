// validations.ts
export interface ValidationErrors {
  provincia?: string;
  ciudad?: string;
  dirección?: string;
  nombre?: string;
  username?: string;
  apellido?: string;
  password?: string;
}

export const storeValidation = (
  provincia: string,
  ciudad: string,
  dirección: string
): ValidationErrors => {
  const newErrors: ValidationErrors = {};

  if (!provincia) {
    newErrors.provincia = "El campo 'nombre' no debe estar vacío.";
  } else if (provincia.length < 2) {
    newErrors.provincia = "El campo 'nombre' debe tener al menos 2 caracteres.";
  }

  if (!ciudad) {
    newErrors.ciudad = "El campo 'apellido' no debe estar vacío.";
  } else if (ciudad.length < 2) {
    newErrors.ciudad = "El campo 'apellido' debe tener al menos 2 caracteres.";
  }

  if (!dirección) {
    newErrors.dirección = "El campo 'dirección' no debe estar vacío.";
  } else if (dirección.length < 2) {
    newErrors.dirección =
      "El campo 'dirección' debe tener al menos 2 caracteres.";
  }

  return newErrors;
};

export const userValidationWithPassword = (
  nombre: string,
  username: string,
  apellido: string
): ValidationErrors => {
  const newErrors: ValidationErrors = {};

  if (!nombre) {
    newErrors.nombre = "El campo 'nombre' no debe estar vacío.";
  } else if (nombre.length < 2) {
    newErrors.nombre = "El campo 'nombre' debe tener al menos 2 caracteres.";
  }

  if (!username) {
    newErrors.username = "El campo 'username' no debe estar vacío.";
  } else if (username.length < 2) {
    newErrors.username =
      "El campo 'username' debe tener al menos 2 caracteres.";
  }

  if (!apellido) {
    newErrors.apellido = "El campo 'apellido' no debe estar vacío.";
  } else if (apellido.length < 2) {
    newErrors.apellido =
      "El campo 'apellido' debe tener al menos 2 caracteres.";
  }
  return newErrors;
};

export const userValidationWithoutPassword = (
  nombre: string,
  username: string,
  apellido: string,
  password: string
): ValidationErrors => {
  const newErrors: ValidationErrors = userValidationWithPassword(
    nombre,
    username,
    apellido
  );

  if (!password) {
    newErrors.password = "El campo 'password' no debe estar vacío.";
  } else if (password.length < 2) {
    newErrors.password =
      "El campo 'password' debe tener al menos 2 caracteres.";
  }

  return newErrors;
};
