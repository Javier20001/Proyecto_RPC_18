import { configureStore } from "@reduxjs/toolkit";
import UserReducer from "../slices/UserSlice";
import StoreReducer from "../slices/StoreSlice";
import ProductReducer from "../slices/ProductSlice";
import ProductoEnTiendaReducer from "../slices/ProductoEnTiendaSlice";
import PurchaseOrderReducer from "../slices/PurchaseOrderSlice";
import NewsReducer from "../slices/NewSlice";

export const store = configureStore({
  reducer: {
    user: UserReducer,
    store: StoreReducer,
    product: ProductReducer,
    productoTienda: ProductoEnTiendaReducer,
    PurchaseOrder: PurchaseOrderReducer,
    news: NewsReducer,
  },
});

export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;
