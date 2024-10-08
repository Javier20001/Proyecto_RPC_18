import React, { createContext, ReactNode, useContext, useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import {
  fetchUsers,
  addUser,
  updateUser,
  deleteUser,
} from "../redux/slices/UserSlice"; // Importa las acciones del slice
import { AppDispatch, RootState } from "../redux/store/store"; // Ajusta según tu configuración de store
import { User, UserDTO } from "../redux/types";

// Define la interfaz del contexto
interface UserContextProps {
  users: User[];
  create_User: (userDTO: UserDTO) => void;
  modify_User: (id: number, userDTO: UserDTO) => void;
  remove_User: (id: number) => void;
}

// Crea el contexto
const UserContext = createContext<UserContextProps | undefined>(undefined);

interface userProviderProps {
  children: ReactNode;
}

// Proveedor del contexto
export const UserProvider: React.FC<userProviderProps> = ({ children }) => {
  const dispatch = useDispatch<AppDispatch>();
  const { users } = useSelector((state: RootState) => state.user);

  useEffect(() => {
    dispatch(fetchUsers());
  }, [dispatch]);

  const create_User = (userDTO: UserDTO) => {
    dispatch(addUser(userDTO));
  };

  const modify_User = (id: number, userDTO: UserDTO) => {
    dispatch(updateUser({ userDTO, id }));
  };

  const remove_User = (id: number) => {
    dispatch(deleteUser(id));
  };

  return (
    <UserContext.Provider
      value={{
        users,
        create_User,
        modify_User,
        remove_User,
      }}
    >
      {children}
    </UserContext.Provider>
  );
};

// Hook personalizado para usar el contexto de usuario
export const useUserContext = () => {
  const context = useContext(UserContext);
  if (!context) {
    throw new Error("useUserContext debe ser usado dentro de UserProvider");
  }
  return context;
};
