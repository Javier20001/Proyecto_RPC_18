import { createSlice, createAsyncThunk, PayloadAction } from "@reduxjs/toolkit";
import axios from "axios";

import { handleAxiosError } from "../../Errors/HandlerAxiosError";
import { Producto, ProductoDTO } from "../types";

interface ProductsState {
  products: Producto[];
  status: "idle" | "loading" | "succeeded" | "failed";
  error: string | null;
}

const initialState: ProductsState = {
  products: [
    {
      idProducto: 1,
      nombre: "remera roja",
      codigo: "jh421g4",
      talle: "m",
      color: "rojo",
      foto: "remera_roja_m.jpg",
      stock: 10,
    },
    {
      idProducto: 2,
      nombre: "remera roja", // "remera roja"
      codigo: "noi42h1o",
      talle: "s",
      color: "rojo",
      foto: "remera_roja_s.jpg",
      stock: 5,
    },
  ],
  status: "idle",
  error: null,
};

// Traer todos los productos
export const fetchProducts = createAsyncThunk(
  "products/fetchProducts",
  async () => {
    const response = await axios.get<Producto[]>(
      "http://localhost:8080/productos"
    );
    return response.data;
  }
);

// Agregar producto
export const addProduct = createAsyncThunk(
  "product/addProduct",
  async (productDTO: ProductoDTO, { rejectWithValue }) => {
    try {
      const response = await axios.post<Producto>(
        "http://localhost:8080/productos",
        productDTO
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

// Actualizar producto
export const updateProduct = createAsyncThunk(
  "product/updateProduct",
  async (
    { productDTO, id }: { productDTO: ProductoDTO; id: number },
    { rejectWithValue }
  ) => {
    try {
      const response = await axios.put<Producto>(
        `http://localhost:8080/productos/${id}`,
        productDTO
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

// Eliminar producto
export const deleteProduct = createAsyncThunk(
  "product/deleteProduct",
  async (productId: number) => {
    await axios.delete(`http://localhost:8080/productos/${productId}`);
    return productId;
  }
);

const productsSlice = createSlice({
  name: "products",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      //   Casos para traer todos los productos
      .addCase(fetchProducts.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        fetchProducts.fulfilled,
        (state, action: PayloadAction<Producto[]>) => {
          state.status = "succeeded";
          state.products = action.payload;
        }
      )
      .addCase(fetchProducts.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.error.message || "Something went wrong";
      })

      // Casos para agregar productos
      .addCase(addProduct.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        addProduct.fulfilled,
        (state, action: PayloadAction<Producto>) => {
          state.status = "succeeded";
          if (!Array.isArray(state.products)) {
            state.products = [];
          }
          // Agregar el nuevo producto a la lista de productos
          state.products.push(action.payload);
        }
      )
      .addCase(addProduct.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })
      // Casos para actualizar productos
      .addCase(updateProduct.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        updateProduct.fulfilled,
        (state, action: PayloadAction<Producto>) => {
          state.status = "succeeded";
          // Buscar el índice del producto a actualizar
          const index = state.products.findIndex(
            (product) => product.idProducto === action.payload.idProducto
          );
          // Si lo encuentra, actualiza el producto en el array
          if (index !== -1) {
            state.products[index] = action.payload;
          }
        }
      )
      .addCase(updateProduct.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })
      // Casos para eliminar productos
      .addCase(deleteProduct.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        deleteProduct.fulfilled,
        (state, action: PayloadAction<number>) => {
          state.status = "succeeded";
          // Elimina el producto filtrando por ID
          state.products = state.products.filter(
            (product) => product.idProducto !== action.payload
          );
        }
      )
      .addCase(deleteProduct.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.error.message || "Algo salió mal";
      });
  },
});

export default productsSlice.reducer;
