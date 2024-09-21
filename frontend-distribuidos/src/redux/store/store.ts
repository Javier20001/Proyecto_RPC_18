import { configureStore } from "@reduxjs/toolkit";
import UserReducer from "../slices/UserSlice";
import StoreReducer from "../slices/StoreSlice";
import ProductReducer from "../slices/ProductSlice";
import ProductoEnTiendaReducer from "../slices/ProductoEnTiendaSlice";

export const store = configureStore({
  reducer: {
    user: UserReducer,
    store: StoreReducer,
    product: ProductReducer,
    productoTienda: ProductoEnTiendaReducer,
  },
});

export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;
