import React, { createContext, ReactNode, useContext, useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchNoAceptadas, darDeAltaProducto } from "../redux/slices/NewSlice";
import { AppDispatch, RootState } from "../redux/store/store";
import { ProductoNovedades } from "../redux/types";

type NewsContextType = {
  novedades: ProductoNovedades[];
  fetch_Novedades_No_Aceptadas: () => void;
  dar_De_Alta_Novedad: (id: number) => void;
};

const NewsContext = createContext<NewsContextType | undefined>(undefined);

interface NewsProviderProps {
  children: ReactNode;
}

export const NewsProvider: React.FC<NewsProviderProps> = ({ children }) => {
  const dispatch = useDispatch<AppDispatch>();
  const novedades = useSelector((state: RootState) => state.news.novedades);

  useEffect(() => {
    dispatch(fetchNoAceptadas());
  }, [dispatch]);

  const fetch_Novedades_No_Aceptadas = () => {
    dispatch(fetchNoAceptadas());
  };

  const dar_De_Alta_Novedad = (id: number) => {
    dispatch(darDeAltaProducto(id));
  };

  return (
    <NewsContext.Provider
      value={{
        novedades,
        fetch_Novedades_No_Aceptadas,
        dar_De_Alta_Novedad,
      }}
    >
      {children}
    </NewsContext.Provider>
  );
};

export const useNewsContext = () => {
  const context = useContext(NewsContext);
  if (context === undefined) {
    throw new Error("useNewsContext debe ser usado dentro de un NewsProvider");
  }
  return context;
};

export default NewsProvider;
