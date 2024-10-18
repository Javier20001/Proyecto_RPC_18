import React, {
  createContext,
  useState,
  useEffect,
  ReactNode,
  useContext,
} from "react";
import { useNavigate } from "react-router-dom"; // Importar useNavigate

interface AuthContextType {
  isAuthenticated: boolean;
  login: (token: string, idUser: number) => void;
  logout: () => void;
  rol: string;
  id: number;
}

export const AuthContext = createContext<AuthContextType | undefined>(
  undefined
);

export const AuthProvider: React.FC<{ children: ReactNode }> = ({
  children,
}) => {
  const [isAuthenticated, setIsAuthenticated] = useState<boolean>(false);
  const navigate = useNavigate();
  const [rol, setRol] = useState<string>("");
  const [id, setid] = useState<number>(0);

  useEffect(() => {
    const token = localStorage.getItem("token");
    if (token) {
      setIsAuthenticated(true);
    }
  }, []);

  const login = (token: string, idUser: number) => {
    localStorage.setItem("token", token);
    setRol(token);
    setid(idUser);
    setIsAuthenticated(true);
  };

  const logout = () => {
    localStorage.removeItem("token");
    setIsAuthenticated(false);
    navigate("/");
  };

  return (
    <AuthContext.Provider value={{ isAuthenticated, login, logout, rol, id }}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuthContext = () => {
  const context = useContext(AuthContext);
  if (context === undefined) {
    throw new Error(
      "useProductoEnTiendaContext debe ser usado dentro de un ProductoEnTiendaProvider"
    );
  }
  return context;
};

export default useAuthContext;
