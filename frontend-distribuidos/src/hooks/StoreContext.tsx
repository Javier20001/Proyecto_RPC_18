import React, {
  createContext,
  useEffect,
  ReactNode,
  useContext,
  useState,
} from "react";
import { useDispatch, useSelector } from "react-redux";
import {
  fetchStores,
  addStore,
  updateStore,
  deleteStore,
  findByID,
  findByCodigo,
  fetchHabilitadas,
} from "../redux/slices/StoreSlice";
import { AppDispatch, RootState } from "../redux/store/store";
import { Tienda, TiendaDTO } from "../redux/types";

type StoreContextType = {
  stores: Tienda[];
  filteredStores: Tienda[];
  fetch_all: () => void;
  add_Store: (storeDTO: TiendaDTO) => void;
  update_Store: (storeDTO: TiendaDTO, id: number) => void;
  delete_Store: (id: number) => void;
  find_by_id: (storeId: number) => void;
  find_by_codigo: (codigo: string) => void;
  fetch_habilitadas: () => void;
  filter_no_habilitadas: () => void;
};

const StoreContext = createContext<StoreContextType | undefined>(undefined);

interface StoreProviderProps {
  children: ReactNode;
}

export const StoreProvider: React.FC<StoreProviderProps> = ({ children }) => {
  const dispatch = useDispatch<AppDispatch>();
  const stores = useSelector((state: RootState) => state.store.stores);

  const [filteredStores, setFilteredStores] = useState<Tienda[]>([]);

  useEffect(() => {
    dispatch(fetchStores());
  }, [dispatch]);

  const fetch_all = () => dispatch(fetchStores());

  const add_Store = (storeDTO: TiendaDTO) => dispatch(addStore(storeDTO));

  const update_Store = (storeDTO: TiendaDTO, id: number) =>
    dispatch(updateStore({ storeDTO, id }));

  const delete_Store = (id: number) => dispatch(deleteStore(id));

  const find_by_id = (storeId: number) => dispatch(findByID({ storeId }));

  const find_by_codigo = (codigo: string) => dispatch(findByCodigo({ codigo }));

  const fetch_habilitadas = () => {
    dispatch(fetchHabilitadas());
    setFilteredStores([]);
  };

  const filter_no_habilitadas = () => {
    const noHabilitadas = stores.filter((store) => !store.habilitada);
    setFilteredStores(noHabilitadas);
  };

  return (
    <StoreContext.Provider
      value={{
        stores,
        filteredStores,
        fetch_all,
        add_Store,
        update_Store,
        delete_Store,
        find_by_id,
        find_by_codigo,
        fetch_habilitadas,
        filter_no_habilitadas,
      }}
    >
      {children}
    </StoreContext.Provider>
  );
};

export const useStoreContext = () => {
  const context = useContext(StoreContext);
  if (context === undefined) {
    throw new Error("useStoreContext must be used within a StoreProvider");
  }
  return context;
};

export default StoreProvider;
