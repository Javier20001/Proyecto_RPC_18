import React, { createContext, useEffect, ReactNode, useContext } from "react";
import { useDispatch, useSelector } from "react-redux";
import {
  fetchStores,
  addStore,
  updateStore,
  deleteStore,
  findByID,
} from "../redux/slices/StoreSlice";
import { AppDispatch, RootState } from "../redux/store/store";
import { Tienda, TiendaDTO } from "../redux/types";

type StoreContextType = {
  stores: Tienda[];
  add_Store: (storeDTO: TiendaDTO) => void;
  update_Store: (storeDTO: TiendaDTO, id: number) => void;
  delete_Store: (id: number) => void;
  find_by_id: (storeId: number) => void;
};

const StoreContext = createContext<StoreContextType | undefined>(undefined);

interface StoreProviderProps {
  children: ReactNode;
}

export const StoreProvider: React.FC<StoreProviderProps> = ({ children }) => {
  const dispatch = useDispatch<AppDispatch>();
  const stores = useSelector((state: RootState) => state.store.stores);

  useEffect(() => {
    dispatch(fetchStores());
  }, [dispatch]);

  const add_Store = (storeDTO: TiendaDTO) => dispatch(addStore(storeDTO));

  const update_Store = (storeDTO: TiendaDTO, id: number) =>
    dispatch(updateStore({ storeDTO, id }));

  const delete_Store = (id: number) => dispatch(deleteStore(id));

  const find_by_id = (storeId: number) => dispatch(findByID({ storeId }));

  return (
    <StoreContext.Provider
      value={{
        stores,
        add_Store,
        update_Store,
        delete_Store,
        find_by_id,
      }}
    >
      {children}
    </StoreContext.Provider>
  );
};

export const useStoreContext = () => {
  const context = useContext(StoreContext);
  if (context === undefined) {
    throw new Error("useAppContext must be used within an AppProvider");
  }
  return context;
};

export default StoreProvider;
