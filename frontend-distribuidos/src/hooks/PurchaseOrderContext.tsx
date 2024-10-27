import React, { createContext, ReactNode, useContext, useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import {
  addOrdenDeCompra,
  fetchAcceptedOrdenesDeCompra,
  fetchAllOrdenesDeCompra,
  receiveOrdenDeCompra,
} from "../redux/slices/PurchaseOrderSlice"; // Ajusta las importaciones según tu estructura
import { AppDispatch, RootState } from "../redux/store/store";
import { OrdenDeCompraModel } from "../redux/types";

interface OrdenDeCompraContextProps {
  ordenesDeCompra: OrdenDeCompraModel[];
  createOrdenDeCompra: (ordenDTO: OrdenDeCompraModel) => void;
  getAcceptedOrdenesDeCompra: (idTienda: number) => void;
  getAllOrdenesDeCompra: () => void;
  receiveOrden: (idTienda: number, idOrden: number) => void;
  status: "idle" | "loading" | "succeeded" | "failed";
  error: string | null;
}

const OrdenDeCompraContext = createContext<
  OrdenDeCompraContextProps | undefined
>(undefined);

interface OrdenDeCompraProviderProps {
  children: ReactNode;
}

export const OrdenDeCompraProvider: React.FC<OrdenDeCompraProviderProps> = ({
  children,
}) => {
  const dispatch = useDispatch<AppDispatch>();
  const { ordenesDeCompra, status, error } = useSelector(
    (state: RootState) => state.PurchaseOrder
  );

  useEffect(() => {
    dispatch(fetchAllOrdenesDeCompra());
  }, [dispatch]);

  const createOrdenDeCompra = (ordenDTO: OrdenDeCompraModel) => {
    dispatch(addOrdenDeCompra(ordenDTO));
  };

  const getAcceptedOrdenesDeCompra = (idTienda: number) => {
    dispatch(fetchAcceptedOrdenesDeCompra(idTienda));
  };

  const getAllOrdenesDeCompra = () => {
    dispatch(fetchAllOrdenesDeCompra());
  };

  const receiveOrden = (idTienda: number, idOrden: number) => {
    dispatch(receiveOrdenDeCompra({ idTienda, idOrden }));
  };

  return (
    <OrdenDeCompraContext.Provider
      value={{
        ordenesDeCompra,
        createOrdenDeCompra,
        getAcceptedOrdenesDeCompra,
        getAllOrdenesDeCompra,
        receiveOrden,
        status,
        error,
      }}
    >
      {children}
    </OrdenDeCompraContext.Provider>
  );
};

export const useOrdenDeCompraContext = () => {
  const context = useContext(OrdenDeCompraContext);
  if (!context) {
    throw new Error(
      "useOrdenDeCompraContext debe ser usado dentro de OrdenDeCompraProvider"
    );
  }
  return context;
};
