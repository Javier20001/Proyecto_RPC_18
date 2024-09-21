import { createSlice, createAsyncThunk, PayloadAction } from "@reduxjs/toolkit";
import axios from "axios";
import { handleAxiosError } from "../../Errors/HandlerAxiosError";
import {
  AsignarProductoEnTiendaDTO,
  filterProductoTiendaDTO,
  ProductoEnTienda,
  ProductoEnTiendaDTO,
  updatProductStock,
} from "../types";

interface ProductosEnTiendaState {
  productosEnTienda: ProductoEnTienda[];
  status: "idle" | "loading" | "succeeded" | "failed";
  error: string | null;
}

const initialState: ProductosEnTiendaState = {
  productosEnTienda: [],
  status: "idle",
  error: null,
};

// Traer todos los productos que esten o no en tienda

export const fetchProductosEnTienda = createAsyncThunk(
  "productosEnTienda/fetchProductosEnTienda",
  async () => {
    const response = await axios.get<ProductoEnTienda[]>(
      "http://127.0.0.1:8081/productos_manager"
    );
    return response.data;
  }
);

// Traer productos en tienda por tienda_id
export const fetchProductosEnTiendaByTiendaId = createAsyncThunk(
  "productosEnTienda/fetchProductosEnTiendaByTiendaId",
  async (tienda_id: number, { rejectWithValue }) => {
    try {
      const response = await axios.get<ProductoEnTienda[]>(
        `http://127.0.0.1:8081/productos/tienda/${tienda_id}_manager`
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        `Error al obtener los productos de la tienda con ID ${tienda_id}`
      );
      return rejectWithValue(errorMessage);
    }
  }
);

// Traer producto en tienda por producto_id y tienda_id
export const fetchProductoEnTiendaById = createAsyncThunk(
  "productosEnTienda/fetchProductoEnTiendaById",
  async (
    { producto_id, tienda_id }: { producto_id: number; tienda_id: number },
    { rejectWithValue }
  ) => {
    try {
      const response = await axios.get<ProductoEnTienda>(
        `http://127.0.0.1:8081/producto/${producto_id}/tienda/${tienda_id}_manager`
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        `Error al obtener el producto con ID ${producto_id} en la tienda ${tienda_id}`
      );
      return rejectWithValue(errorMessage);
    }
  }
);

// Asignar producto a tienda
export const assignProductoToTienda = createAsyncThunk(
  "productosEnTienda/assignProductoToTienda",
  async (
    { data }: { data: AsignarProductoEnTiendaDTO },
    { rejectWithValue }
  ) => {
    try {
      const response = await axios.post<{ message: string }>(
        "http://127.0.0.1:8081/producto/asignar_manager",
        data
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al asignar el producto a la tienda"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

// Agregar nuevo producto sin asignar la tienda
export const addProductoEnTienda = createAsyncThunk(
  "productosEnTienda/addProductoEnTienda",
  async (
    { productoEnTiendaDTO }: { productoEnTiendaDTO: ProductoEnTiendaDTO },
    { rejectWithValue }
  ) => {
    try {
      const response = await axios.post<ProductoEnTienda>(
        "http://127.0.0.1:8081/producto_manager",
        productoEnTiendaDTO
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al agregar el producto"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

// Actualizar producto en tienda
export const updateProductoEnTienda = createAsyncThunk(
  "productosEnTienda/updateProductoEnTienda",
  async (
    { updateProduct }: { updateProduct: ProductoEnTiendaDTO },
    { rejectWithValue }
  ) => {
    try {
      const response = await axios.put<ProductoEnTienda>(
        "http://127.0.0.1:8081/producto_manager",
        updateProduct
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al actualizar el producto"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

// Modificar stock del producto en tienda
export const updateStock = createAsyncThunk(
  "productosEnTienda/updateStock",
  async (
    { updateData }: { updateData: updatProductStock },
    { rejectWithValue }
  ) => {
    try {
      const response = await axios.put<{
        id: number;
        stock: number;
      }>("http://127.0.0.1:8081/producto/stock_manager", updateData);
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al actualizar el stock del producto"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

// Filtrar productos en tienda
export const filterProductosEnTienda = createAsyncThunk(
  "productosEnTienda/filterProductosEnTienda",
  async (
    { filterData }: { filterData: filterProductoTiendaDTO },
    { rejectWithValue }
  ) => {
    try {
      const response = await axios.post<ProductoEnTienda[]>(
        "http://127.0.0.1:8081/productos/filter_manager",
        filterData
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al filtrar los productos"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

const productoEnTiendaSlice = createSlice({
  name: "productosEnTienda",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      // Casos para traer todos los productos en tienda
      .addCase(fetchProductosEnTienda.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        fetchProductosEnTienda.fulfilled,
        (state, action: PayloadAction<ProductoEnTienda[]>) => {
          state.status = "succeeded";
          state.productosEnTienda = action.payload;
        }
      )
      .addCase(fetchProductosEnTienda.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })

      // Casos para traer productos en tienda por tienda_id
      .addCase(fetchProductosEnTiendaByTiendaId.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        fetchProductosEnTiendaByTiendaId.fulfilled,
        (state, action: PayloadAction<ProductoEnTienda[]>) => {
          state.status = "succeeded";
          state.productosEnTienda = action.payload;
        }
      )
      .addCase(fetchProductosEnTiendaByTiendaId.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })

      // Casos para traer producto en tienda por producto_id y tienda_id
      .addCase(fetchProductoEnTiendaById.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        fetchProductoEnTiendaById.fulfilled,
        (state, action: PayloadAction<ProductoEnTienda>) => {
          state.status = "succeeded";
          const index = state.productosEnTienda.findIndex(
            (item) =>
              item.id_productoEnTienda === action.payload.id_productoEnTienda
          );
          if (index !== -1) {
            state.productosEnTienda[index] = action.payload;
          } else {
            state.productosEnTienda.push(action.payload);
          }
        }
      )
      .addCase(fetchProductoEnTiendaById.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })

      // Casos para asignar producto a tienda
      .addCase(assignProductoToTienda.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        assignProductoToTienda.fulfilled,
        (state, action: PayloadAction<{ message: string }>) => {
          state.status = "succeeded";
          // Puedes manejar el mensaje de éxito si lo deseas
        }
      )
      .addCase(assignProductoToTienda.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })

      // Casos para agregar nuevo producto en tienda
      .addCase(addProductoEnTienda.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        addProductoEnTienda.fulfilled,
        (state, action: PayloadAction<ProductoEnTienda>) => {
          state.status = "succeeded";
          state.productosEnTienda.push(action.payload);
        }
      )
      .addCase(addProductoEnTienda.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })

      // Casos para actualizar producto en tienda
      .addCase(updateProductoEnTienda.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        updateProductoEnTienda.fulfilled,
        (state, action: PayloadAction<ProductoEnTienda>) => {
          state.status = "succeeded";
          const index = state.productosEnTienda.findIndex(
            (item) =>
              item.id_productoEnTienda === action.payload.id_productoEnTienda
          );
          if (index !== -1) {
            state.productosEnTienda[index] = action.payload;
          }
        }
      )
      .addCase(updateProductoEnTienda.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })

      // Casos para actualizar stock del producto en tienda
      .addCase(updateStock.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        updateStock.fulfilled,
        (state, action: PayloadAction<{ id: number; stock: number }>) => {
          state.status = "succeeded";
          const index = state.productosEnTienda.findIndex(
            (item) => item.id_productoEnTienda === action.payload.id
          );
          if (index !== -1) {
            state.productosEnTienda[index].stock = action.payload.stock;
          }
        }
      )
      .addCase(updateStock.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })

      // Casos para filtrar productos en tienda
      .addCase(filterProductosEnTienda.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        filterProductosEnTienda.fulfilled,
        (state, action: PayloadAction<ProductoEnTienda[]>) => {
          state.status = "succeeded";
          state.productosEnTienda = action.payload;
        }
      )
      .addCase(filterProductosEnTienda.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      });
  },
});

export default productoEnTiendaSlice.reducer;
