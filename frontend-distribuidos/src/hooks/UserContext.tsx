import React, { createContext, ReactNode, useContext, useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import {
  fetchUsers,
  addUser,
  updateUser,
  deleteUser,
  findUserByUsername,
  findUsersByTienda,
} from "../redux/slices/UserSlice";
import { AppDispatch, RootState } from "../redux/store/store";
import { User, UserDTO } from "../redux/types";

interface UserContextProps {
  users: User[];
  fetch_all_user: () => void;
  create_User: (userDTO: UserDTO) => void;
  modify_User: (id: number, userDTO: UserDTO) => void;
  remove_User: (id: number) => void;
  find_User_By_Username: (username: string) => void;
  find_Users_By_Tienda: (tienda_id: number) => void;
}

const UserContext = createContext<UserContextProps | undefined>(undefined);

interface userProviderProps {
  children: ReactNode;
}

export const UserProvider: React.FC<userProviderProps> = ({ children }) => {
  const dispatch = useDispatch<AppDispatch>();
  const { users } = useSelector((state: RootState) => state.user);

  useEffect(() => {
    dispatch(fetchUsers());
  }, [dispatch]);

  const fetch_all_user = () => {
    dispatch(fetchUsers());
  };

  const create_User = (userDTO: UserDTO) => {
    dispatch(addUser(userDTO));
  };

  const modify_User = (id: number, userDTO: UserDTO) => {
    dispatch(updateUser({ userDTO, id }));
  };

  const remove_User = (id: number) => {
    dispatch(deleteUser(id));
  };

  const find_User_By_Username = (username: string) => {
    dispatch(findUserByUsername(username));
  };

  const find_Users_By_Tienda = (tienda_id: number) => {
    dispatch(findUsersByTienda(tienda_id));
  };

  return (
    <UserContext.Provider
      value={{
        users,
        fetch_all_user,
        create_User,
        modify_User,
        remove_User,
        find_User_By_Username,
        find_Users_By_Tienda,
      }}
    >
      {children}
    </UserContext.Provider>
  );
};

export const useUserContext = () => {
  const context = useContext(UserContext);
  if (!context) {
    throw new Error("useUserContext debe ser usado dentro de UserProvider");
  }
  return context;
};
