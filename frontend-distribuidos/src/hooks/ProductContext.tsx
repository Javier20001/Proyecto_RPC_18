import React, { createContext, ReactNode, useContext, useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import {
  fetchProductosEnTienda,
  fetchProductosEnTiendaByTiendaId,
  fetchProductoEnTiendaById,
  assignProductoToTienda,
  addProductoEnTienda,
  updateProductoEnTienda,
  updateStock,
  filterProductosEnTienda,
} from "../redux/slices/ProductoEnTiendaSlice";
import { AppDispatch, RootState } from "../redux/store/store";
import {
  ProductoEnTiendaDTO,
  AsignarProductoEnTiendaDTO,
  updatProductStock,
  filterProductoTiendaDTO,
  ProductoEnTienda,
} from "../redux/types";

type ProductoEnTiendaContextType = {
  productosEnTienda: ProductoEnTienda[];
  fetch_All_Productos: () => void;
  fetch_By_Tienda_Id: (tiendaId: number) => void;
  fetch_By_Id: (productoId: number, tiendaId: number) => void;
  assign_Producto: (data: AsignarProductoEnTiendaDTO) => void;
  add_Producto: (productoEnTiendaDTO: ProductoEnTiendaDTO) => void;
  update_Producto: (productoEnTiendaDTO: ProductoEnTiendaDTO) => void;
  update_Stock: (updateData: updatProductStock) => void;
  filter_Productos: (filterData: filterProductoTiendaDTO) => void;
  filter_Productos_By_Tienda: (tiendaId: number) => ProductoEnTienda[];
};

const ProductoEnTiendaContext = createContext<
  ProductoEnTiendaContextType | undefined
>(undefined);

interface ProductoEnTiendaProviderProps {
  children: ReactNode;
}

export const ProductoEnTiendaProvider: React.FC<
  ProductoEnTiendaProviderProps
> = ({ children }) => {
  const dispatch = useDispatch<AppDispatch>();
  const productosEnTienda = useSelector(
    (state: RootState) => state.productoTienda.productosEnTienda
  );

  useEffect(() => {
    dispatch(fetchProductosEnTienda());
  }, [dispatch]);

  const fetch_All_Productos = () => {
    dispatch(fetchProductosEnTienda());
  };

  const fetch_By_Tienda_Id = (tiendaId: number) => {
    dispatch(fetchProductosEnTiendaByTiendaId(tiendaId));
  };

  const fetch_By_Id = (productoId: number, tiendaId: number) => {
    dispatch(
      fetchProductoEnTiendaById({
        producto_id: productoId,
        tienda_id: tiendaId,
      })
    );
  };

  const assign_Producto = (data: AsignarProductoEnTiendaDTO) => {
    dispatch(assignProductoToTienda({ data }));
  };

  const add_Producto = (productoEnTiendaDTO: ProductoEnTiendaDTO) => {
    dispatch(addProductoEnTienda({ productoEnTiendaDTO }));
  };

  const update_Producto = (productoEnTiendaDTO: ProductoEnTiendaDTO) => {
    dispatch(updateProductoEnTienda({ updateProduct: productoEnTiendaDTO }));
  };

  const update_Stock = (updateData: updatProductStock) => {
    dispatch(updateStock({ updateData }));
  };

  const filter_Productos = (filterData: filterProductoTiendaDTO) => {
    dispatch(filterProductosEnTienda({ filterData }));
  };

  const filter_Productos_By_Tienda = (tiendaId: number) => {
    return productosEnTienda.filter(
      (product) => product.tienda?.id === tiendaId
    );
  };

  return (
    <ProductoEnTiendaContext.Provider
      value={{
        productosEnTienda,
        fetch_All_Productos,
        fetch_By_Tienda_Id,
        fetch_By_Id,
        assign_Producto,
        add_Producto,
        update_Producto,
        update_Stock,
        filter_Productos,
        filter_Productos_By_Tienda,
      }}
    >
      {children}
    </ProductoEnTiendaContext.Provider>
  );
};

export const useProductoEnTiendaContext = () => {
  const context = useContext(ProductoEnTiendaContext);
  if (context === undefined) {
    throw new Error(
      "useProductoEnTiendaContext debe ser usado dentro de un ProductoEnTiendaProvider"
    );
  }
  return context;
};

export default ProductoEnTiendaProvider;
