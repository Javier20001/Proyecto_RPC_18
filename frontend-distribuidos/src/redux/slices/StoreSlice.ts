import { createSlice, createAsyncThunk, PayloadAction } from "@reduxjs/toolkit";
import axios from "axios";
import { handleAxiosError } from "../../Errors/HandlerAxiosError";
import { Tienda, TiendaDTO } from "../types";

interface StoresState {
  stores: Tienda[];
  status: "idle" | "loading" | "succeeded" | "failed";
  error: string | null;
}

const initialState: StoresState = {
  stores: [],
  status: "idle",
  error: null,
};

// Métodos existentes
export const fetchStores = createAsyncThunk("stores/fetchStores", async () => {
  const response = await axios.get<Tienda[]>("http://127.0.0.1:8081/tiendas");
  return response.data;
});

export const addStore = createAsyncThunk(
  "store/addStore",
  async (storeDTO: TiendaDTO, { rejectWithValue }) => {
    try {
      const response = await axios.post<Tienda>(
        "http://localhost:8081/tiendas",
        storeDTO
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al agregar la tienda"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

export const updateStore = createAsyncThunk(
  "store/updateStore",
  async (
    { storeDTO, id }: { storeDTO: TiendaDTO; id: number },
    { rejectWithValue }
  ) => {
    try {
      const response = await axios.put<Tienda>(
        `http://127.0.0.1:8081/tiendas/${id}`,
        storeDTO
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al actualizar la tienda"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

export const deleteStore = createAsyncThunk(
  "store/deleteStore",
  async (storeId: number) => {
    await axios.delete(`http://127.0.0.1:8081/tiendas/${storeId}/disable`);
    return storeId;
  }
);

export const findByID = createAsyncThunk(
  "store/findByID",
  async ({ storeId }: { storeId: number }, { rejectWithValue }) => {
    try {
      const response = await axios.get<Tienda>(
        `http://127.0.0.1:8081/tiendas/${storeId}`
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        `Error al traer la tienda con ID ${storeId}`
      );
      return rejectWithValue(errorMessage);
    }
  }
);

export const findByCodigo = createAsyncThunk(
  "store/findByCodigo",
  async ({ codigo }: { codigo: string }, { rejectWithValue }) => {
    try {
      const response = await axios.get<Tienda[]>(
        `http://127.0.0.1:8081/tiendas/codigo/${codigo}`
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        `Error al traer la tienda con código ${codigo}`
      );
      return rejectWithValue(errorMessage);
    }
  }
);

export const fetchHabilitadas = createAsyncThunk(
  "store/fetchHabilitadas",
  async () => {
    const response = await axios.get<Tienda[]>(
      "http://127.0.0.1:8081/tiendas/habilitadas"
    );
    return response.data;
  }
);

const storeSlice = createSlice({
  name: "stores",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder

      .addCase(fetchStores.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        fetchStores.fulfilled,
        (state, action: PayloadAction<Tienda[]>) => {
          state.status = "succeeded";
          state.stores = action.payload;
        }
      )
      .addCase(fetchStores.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.error.message || "Algo salió mal";
      })

      .addCase(addStore.pending, (state) => {
        state.status = "loading";
      })
      .addCase(addStore.fulfilled, (state, action: PayloadAction<Tienda>) => {
        state.status = "succeeded";
        state.stores.push(action.payload);
      })
      .addCase(addStore.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })

      .addCase(updateStore.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        updateStore.fulfilled,
        (state, action: PayloadAction<Tienda>) => {
          state.status = "succeeded";
          const index = state.stores.findIndex(
            (store) => store.id === action.payload.id
          );
          if (index !== -1) {
            state.stores[index] = action.payload;
          }
        }
      )
      .addCase(updateStore.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })

      .addCase(deleteStore.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        deleteStore.fulfilled,
        (state, action: PayloadAction<number>) => {
          state.status = "succeeded";
          state.stores = state.stores.filter(
            (store) => store.id !== action.payload
          );
        }
      )
      .addCase(deleteStore.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.error.message || "Algo salió mal";
      })

      .addCase(findByID.pending, (state) => {
        state.status = "loading";
      })
      .addCase(findByID.fulfilled, (state, action: PayloadAction<Tienda>) => {
        state.status = "succeeded";
        const index = state.stores.findIndex(
          (store) => store.id === action.payload.id
        );
        if (index !== -1) {
          state.stores[index] = action.payload;
        } else {
          state.stores.push(action.payload);
        }
      })
      .addCase(findByID.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })

      .addCase(findByCodigo.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        findByCodigo.fulfilled,
        (state, action: PayloadAction<Tienda[]>) => {
          state.status = "succeeded";
          state.stores = action.payload;
        }
      )
      .addCase(findByCodigo.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })

      .addCase(fetchHabilitadas.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        fetchHabilitadas.fulfilled,
        (state, action: PayloadAction<Tienda[]>) => {
          state.status = "succeeded";
          state.stores = action.payload;
        }
      )
      .addCase(fetchHabilitadas.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.error.message || "Algo salió mal";
      });
  },
});

export default storeSlice.reducer;
