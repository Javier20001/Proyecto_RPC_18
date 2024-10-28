import { createSlice, createAsyncThunk, PayloadAction } from "@reduxjs/toolkit";
import axios from "axios";
import { handleAxiosError } from "../../Errors/HandlerAxiosError";
import { Filtro, FiltroAdd, FiltroUpdate } from "../types";

interface FiltroState {
  filtros: Filtro[];
  status: "idle" | "loading" | "succeeded" | "failed";
  error: string | null;
}

const initialState: FiltroState = {
  filtros: [],
  status: "idle",
  error: null,
};

export const addFiltro = createAsyncThunk(
  "filtros/addFiltro",
  async (filtro: FiltroAdd, { rejectWithValue }) => {
    try {
      const response = await axios.post(
        "http://127.0.0.1:8087/api/v2/ordenesDeCompra/addFiltro",
        filtro
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al agregar el filtro"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

export const getFiltrosByUsuario = createAsyncThunk(
  "filtros/getFiltrosByUsuario",
  async (usuarioId: number, { rejectWithValue }) => {
    try {
      const response = await axios.get<Filtro[]>(
        `http://127.0.0.1:8087/api/v2/ordenesDeCompra/filtros/${usuarioId}`
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al obtener los filtros del usuario"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

export const updateFiltro = createAsyncThunk(
  "filtros/updateFiltro",
  async (filtro: FiltroUpdate, { rejectWithValue }) => {
    try {
      const response = await axios.put(
        "http://localhost:8087/api/v2/ordenesDeCompra/updateFiltro",
        filtro
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al actualizar el filtro"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

export const deleteFiltro = createAsyncThunk(
  "filtros/deleteFiltro",
  async (filtroId: number, { rejectWithValue }) => {
    try {
      await axios.delete(
        `http://localhost:8087/api/v2/ordenesDeCompra/deleteFiltro/${filtroId}`
      );
      return filtroId;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al eliminar el filtro"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

const filtrosSlice = createSlice({
  name: "filtros",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder

      .addCase(addFiltro.pending, (state) => {
        state.status = "loading";
      })
      .addCase(addFiltro.fulfilled, (state, action: PayloadAction<Filtro>) => {
        state.status = "succeeded";
        if (Array.isArray(state.filtros)) {
          state.filtros.push(action.payload);
        } else {
          state.filtros = [action.payload];
        }
      })
      .addCase(addFiltro.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })

      .addCase(getFiltrosByUsuario.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        getFiltrosByUsuario.fulfilled,
        (state, action: PayloadAction<Filtro[]>) => {
          state.status = "succeeded";

          state.filtros = action.payload.filtros; //esto esta bien ya que dentro del payload hay una lista de filtros
        }
      )
      .addCase(getFiltrosByUsuario.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })

      .addCase(updateFiltro.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        updateFiltro.fulfilled,
        (state, action: PayloadAction<Filtro>) => {
          state.status = "succeeded";

          const index = state.filtros.findIndex(
            (f) => f.id === action.payload.id
          );
          if (index !== -1) {
            state.filtros[index] = action.payload;
          }
        }
      )
      .addCase(updateFiltro.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })

      .addCase(deleteFiltro.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        deleteFiltro.fulfilled,
        (state, action: PayloadAction<number>) => {
          state.status = "succeeded";
          state.filtros = state.filtros.filter((f) => f.id !== action.payload);
        }
      )
      .addCase(deleteFiltro.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      });
  },
});

export default filtrosSlice.reducer;
