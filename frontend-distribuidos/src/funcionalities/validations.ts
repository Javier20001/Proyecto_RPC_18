// validations.ts
export interface ValidationErrors {
  provincia?: string;
  ciudad?: string;
  dirección?: string;
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

// export const validationTime = (
//   startTime: string,
//   endTime: string
// ): ValidationErrors => {
//   const newErrors: ValidationErrors = {};

//   if (!startTime) {
//     newErrors.startTime = "El campo 'Horr Inicio' no debe estar vacío.";
//   }

//   if (!endTime) {
//     newErrors.endTime = "El campo 'Hora Fin' no debe estar vacío.";
//   }
//   return newErrors;
// };

// export const validateFormSpecialist = (
//   firstName: string,
//   lastName: string,
//   dni: string,
//   email: string
// ): ValidationErrors => {
//   const newErrors: ValidationErrors = {};

//   if (!firstName) {
//     newErrors.firstName = "El campo 'nombre' no debe estar vacío.";
//   } else if (firstName.length < 2) {
//     newErrors.firstName = "El campo 'nombre' debe tener al menos 2 caracteres.";
//   }

//   if (!lastName) {
//     newErrors.lastName = "El campo 'apellido' no debe estar vacío.";
//   } else if (lastName.length < 2) {
//     newErrors.lastName =
//       "El campo 'apellido' debe tener al menos 2 caracteres.";
//   }

//   if (!dni) {
//     newErrors.dni = "El campo 'dni' no debe estar vacío.";
//   } else if (dni.length < 7 || dni.length > 8) {
//     newErrors.dni = "El campo 'dni' debe tener entre 7 y 8 dígitos.";
//   } else if (!/^\d+$/.test(dni)) {
//     newErrors.dni = "El campo 'dni' debe contener solo dígitos númericos.";
//   }

//   //const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
//   if (!email) {
//     newErrors.email = "El campo 'email' no debe estar vacío.";
//   }
//   //   } else if (!emailRegex.test(email)) {
//   //     newErrors.email =
//   //       "El campo 'email' debe ser una dirección de correo electrónico válida.";
//   //   }

//   return newErrors;
// };
