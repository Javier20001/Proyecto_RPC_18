import { createSlice, createAsyncThunk, PayloadAction } from "@reduxjs/toolkit";
import axios from "axios";
import { handleAxiosError } from "../../Errors/HandlerAxiosError";
import { ProductoNovedades } from "../types";

interface NewsState {
  novedades: ProductoNovedades[];
  status: "idle" | "loading" | "succeeded" | "failed";
  error: string | null;
}

const initialState: NewsState = {
  novedades: [],
  status: "idle",
  error: null,
};

export const fetchNoAceptadas = createAsyncThunk(
  "news/fetchNoAceptadas",
  async (_, { rejectWithValue }) => {
    try {
      const response = await axios.get<ProductoNovedades[]>(
        "http://127.0.0.1:8085/api/v1/novedades"
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al obtener las novedades no aceptadas"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

export const darDeAltaProducto = createAsyncThunk(
  "news/darDeAltaProducto",
  async (id: number, { rejectWithValue }) => {
    try {
      const response = await axios.post<string>(
        `http://127.0.0.1:8085/api/v1/novedades/${id}`
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al aceptar el producto en novedades"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

const newsSlice = createSlice({
  name: "news",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder

      .addCase(fetchNoAceptadas.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        fetchNoAceptadas.fulfilled,
        (state, action: PayloadAction<ProductoNovedades[]>) => {
          state.status = "succeeded";
          state.novedades = action.payload;
        }
      )
      .addCase(fetchNoAceptadas.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })

      .addCase(darDeAltaProducto.pending, (state) => {
        state.status = "loading";
      })
      .addCase(darDeAltaProducto.fulfilled, (state, action) => {
        state.status = "succeeded";

        const id = action.meta.arg;
        state.novedades = state.novedades.map((novedad) =>
          novedad.id === id ? { ...novedad, aceptado: true } : novedad
        );
      })
      .addCase(darDeAltaProducto.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      });
  },
});

export default newsSlice.reducer;
