import { createSlice, createAsyncThunk, PayloadAction } from "@reduxjs/toolkit";
import axios from "axios";
import { handleAxiosError } from "../../Errors/HandlerAxiosError";
import { OrdenDeCompraModel } from "../types";

interface OrdenDeCompraState {
  ordenesDeCompra: OrdenDeCompraModel[];
  status: "idle" | "loading" | "succeeded" | "failed";
  error: string | null;
}

const initialState: OrdenDeCompraState = {
  ordenesDeCompra: [],
  status: "idle",
  error: null,
};

// Thunk para agregar una nueva orden de compra
export const addOrdenDeCompra = createAsyncThunk(
  "ordenesDeCompra/addOrdenDeCompra",
  async (ordenDeCompra: OrdenDeCompraModel, { rejectWithValue }) => {
    try {
      const response = await axios.post<string>(
        "http://127.0.0.1:8085/api/v1/ordenes-de-compra",
        ordenDeCompra
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al agregar la orden de compra"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

// Thunk para obtener todas las órdenes aceptadas y con orden de despacho
export const fetchAcceptedOrdenesDeCompra = createAsyncThunk(
  "ordenesDeCompra/fetchAcceptedOrdenesDeCompra",
  async (idTienda: number, { rejectWithValue }) => {
    try {
      const response = await axios.get<OrdenDeCompraModel[]>(
        `http://127.0.0.1:8085/api/v1/recepcion/${idTienda}`
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al obtener las órdenes de compra aceptadas"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

// Thunk para obtener todas las órdenes de compra
export const fetchAllOrdenesDeCompra = createAsyncThunk(
  "ordenesDeCompra/fetchAllOrdenesDeCompra",
  async (_, { rejectWithValue }) => {
    try {
      const response = await axios.get<OrdenDeCompraModel[]>(
        "http://127.0.0.1:8085/api/v1/recepcion/all"
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al obtener todas las órdenes de compra"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

// Thunk para recibir una orden de compra
export const receiveOrdenDeCompra = createAsyncThunk(
  "ordenesDeCompra/receiveOrdenDeCompra",
  async (
    { idTienda, idOrden }: { idTienda: number; idOrden: number },
    { rejectWithValue }
  ) => {
    try {
      const response = await axios.post<string>(
        `http://127.0.0.1:8085/api/v1/recepcion/${idTienda}/${idOrden}`
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al recibir la orden de compra"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

const ordenDeCompraSlice = createSlice({
  name: "ordenesDeCompra",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      // Manejo del estado para agregar una nueva orden de compra
      .addCase(addOrdenDeCompra.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        addOrdenDeCompra.fulfilled,
        (state, action: PayloadAction<string>) => {
          state.status = "succeeded";
        }
      )
      .addCase(addOrdenDeCompra.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })
      .addCase(fetchAcceptedOrdenesDeCompra.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        fetchAcceptedOrdenesDeCompra.fulfilled,
        (state, action: PayloadAction<OrdenDeCompraModel[]>) => {
          state.status = "succeeded";
          state.ordenesDeCompra = action.payload;
        }
      )
      .addCase(fetchAcceptedOrdenesDeCompra.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })

      .addCase(fetchAllOrdenesDeCompra.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        fetchAllOrdenesDeCompra.fulfilled,
        (state, action: PayloadAction<OrdenDeCompraModel[]>) => {
          state.status = "succeeded";
          state.ordenesDeCompra = action.payload;
        }
      )
      .addCase(fetchAllOrdenesDeCompra.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })
      // Manejo del estado para recibir una orden de compra
      .addCase(receiveOrdenDeCompra.pending, (state) => {
        state.status = "loading";
      })
      .addCase(receiveOrdenDeCompra.fulfilled, (state) => {
        state.status = "succeeded";
        // Podrías manejar una actualización específica del estado si es necesario
      })
      .addCase(receiveOrdenDeCompra.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      });
  },
});

export default ordenDeCompraSlice.reducer;
