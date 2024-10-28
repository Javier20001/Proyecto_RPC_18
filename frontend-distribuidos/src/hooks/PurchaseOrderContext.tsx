import React, { createContext, ReactNode, useContext, useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import {
  addOrdenDeCompra,
  fetchAcceptedOrdenesDeCompra,
  fetchAllOrdenesDeCompra,
  receiveOrdenDeCompra,
  filterOrdenesDeCompra,
  fetchOrdenesDeCompraByFiltroId,
} from "../redux/slices/PurchaseOrderSlice";
import { AppDispatch, RootState } from "../redux/store/store";
import { FiltroBase, OrdenDeCompraModel } from "../redux/types";

interface OrdenDeCompraContextProps {
  ordenesDeCompra: OrdenDeCompraModel[];
  createOrdenDeCompra: (ordenDTO: OrdenDeCompraModel) => void;
  getAcceptedOrdenesDeCompra: (idTienda: number) => void;
  getAllOrdenesDeCompra: () => void;
  filtrarOrdenesDeCompra: (filterOrder: FiltroBase) => void;
  receiveOrden: (idTienda: number, idOrden: number) => void;
  traerOrdenesPorFiltroID: (idfiltro: number) => void;
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
  const { ordenesDeCompra } = useSelector(
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

  const filtrarOrdenesDeCompra = (filterParams: FiltroBase) => {
    dispatch(filterOrdenesDeCompra(filterParams));
  };

  const traerOrdenesPorFiltroID = (filtroId: number) => {
    dispatch(fetchOrdenesDeCompraByFiltroId(filtroId));
  };

  return (
    <OrdenDeCompraContext.Provider
      value={{
        ordenesDeCompra,
        createOrdenDeCompra,
        getAcceptedOrdenesDeCompra,
        getAllOrdenesDeCompra,
        filtrarOrdenesDeCompra,
        receiveOrden,
        traerOrdenesPorFiltroID,
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
