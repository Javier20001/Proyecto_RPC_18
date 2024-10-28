import React, { createContext, ReactNode, useContext, useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import {
  addFiltro,
  getFiltrosByUsuario,
  updateFiltro,
  deleteFiltro,
} from "../redux/slices/FiltrosSlice";
import { AppDispatch, RootState } from "../redux/store/store";
import { Filtro, FiltroAdd, FiltroUpdate } from "../redux/types";
import useAuthContext from "./AuthContext";

type FilterContextType = {
  filtros: Filtro[];
  agregarFiltro: (nuevoFiltro: FiltroAdd) => void;
  obtenerFiltrosPorUsuario: (usuarioId: number) => void;
  actualizarFiltro: (filtroActualizado: FiltroUpdate) => void;
  eliminarFiltro: (filtroId: number) => void;
};

const FilterContext = createContext<FilterContextType | undefined>(undefined);

interface FilterProviderProps {
  children: ReactNode;
}

export const FilterProvider: React.FC<FilterProviderProps> = ({ children }) => {
  const dispatch = useDispatch<AppDispatch>();
  const filtros = useSelector((state: RootState) => state.filter.filtros);

  useEffect(() => {
    dispatch(getFiltrosByUsuario(Number(localStorage.getItem("idUser"))));
  }, [dispatch]);

  const agregarFiltro = (nuevoFiltro: FiltroAdd) => {
    dispatch(addFiltro(nuevoFiltro));
  };

  const obtenerFiltrosPorUsuario = (usuarioId: number) => {
    dispatch(getFiltrosByUsuario(usuarioId));
  };

  const actualizarFiltro = (filtroActualizado: FiltroUpdate) => {
    dispatch(updateFiltro(filtroActualizado));
  };

  const eliminarFiltro = (filtroId: number) => {
    dispatch(deleteFiltro(filtroId));
  };

  return (
    <FilterContext.Provider
      value={{
        filtros,
        agregarFiltro,
        obtenerFiltrosPorUsuario,
        actualizarFiltro,
        eliminarFiltro,
      }}
    >
      {children}
    </FilterContext.Provider>
  );
};

export const useFilterContext = () => {
  const context = useContext(FilterContext);
  if (context === undefined) {
    throw new Error(
      "useFilterContext debe ser usado dentro de un FilterProvider"
    );
  }
  return context;
};

export default FilterProvider;
