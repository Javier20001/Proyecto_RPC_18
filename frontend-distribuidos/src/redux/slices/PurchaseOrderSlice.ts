import { createSlice, createAsyncThunk, PayloadAction } from "@reduxjs/toolkit";
import axios from "axios";
import { handleAxiosError } from "../../Errors/HandlerAxiosError";
import {
  FiltroBase,
  OrdenDeCompraModel,
  ordenesAgrupadas,
  ProductoEnOCModel,
} from "../types";

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

export const filterOrdenesDeCompra = createAsyncThunk(
  "ordenesDeCompra/filterOrdenesDeCompra",
  async (filterParams: FiltroBase, { rejectWithValue }) => {
    try {
      const response = await axios.post<ordenesAgrupadas>(
        "http://127.0.0.1:8087/api/v2/ordenesDeCompra/filtrar",
        filterParams
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al filtrar las órdenes de compra"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

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

export const fetchOrdenesDeCompraByFiltroId = createAsyncThunk(
  "ordenesDeCompra/fetchOrdenesDeCompraByFiltroId",
  async (filtroId: number, { rejectWithValue }) => {
    try {
      const response = await axios.get<ordenesAgrupadas>(
        `http://127.0.0.1:8087/api/v2/ordenesDeCompra/ordenesByFiltro/${filtroId}`
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al obtener las órdenes de compra por ID de filtro"
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
          state.ordenesDeCompra = [];
          state.ordenesDeCompra = action.payload;
        }
      )
      .addCase(fetchAllOrdenesDeCompra.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })
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
      })
      .addCase(filterOrdenesDeCompra.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        filterOrdenesDeCompra.fulfilled,
        (state, action: PayloadAction<ordenesAgrupadas>) => {
          state.status = "succeeded";
          state.ordenesDeCompra = [];
          if (action.payload.ordenesAgrupadas) {
            let idOrder = 1;
            state.ordenesDeCompra = action.payload.ordenesAgrupadas.map(
              (orden) => {
                const productosEnOC: ProductoEnOCModel[] = [
                  {
                    id: idOrder,
                    codigo: orden.codigoProducto,
                    color: "",
                    talle: "",
                    cantidadSolicitada: orden.cantidadTotalPedida,
                  },
                ];

                const nuevaOrdenDeCompra: OrdenDeCompraModel = {
                  id: idOrder,
                  estado: orden.estado,
                  observaciones: "",
                  productosEnOC: productosEnOC,
                  tiendaId: orden.tiendaId,
                  ordenDeDespachoId: 0,
                  fechaDeSolicitud: new Date().toISOString(),
                  fechaDeRecepcion: "",
                  pausada: false,
                };

                idOrder++;
                return nuevaOrdenDeCompra;
              }
            );
          } else {
            state.ordenesDeCompra = [];
          }
        }
      )
      .addCase(filterOrdenesDeCompra.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })
      .addCase(fetchOrdenesDeCompraByFiltroId.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        fetchOrdenesDeCompraByFiltroId.fulfilled,
        (state, action: PayloadAction<ordenesAgrupadas>) => {
          state.status = "succeeded";
          if (action.payload.ordenesAgrupadas) {
            let idOrder = 1;
            state.ordenesDeCompra = action.payload.ordenesAgrupadas.map(
              (orden) => {
                const productosEnOC: ProductoEnOCModel[] = [
                  {
                    id: idOrder,
                    codigo: orden.codigoProducto,
                    color: "",
                    talle: "",
                    cantidadSolicitada: orden.cantidadTotalPedida,
                  },
                ];

                const nuevaOrdenDeCompra: OrdenDeCompraModel = {
                  id: idOrder,
                  estado: orden.estado,
                  observaciones: "",
                  productosEnOC: productosEnOC,
                  tiendaId: orden.tiendaId,
                  ordenDeDespachoId: 0,
                  fechaDeSolicitud: new Date().toISOString(),
                  fechaDeRecepcion: "",
                  pausada: false,
                };

                idOrder++;
                return nuevaOrdenDeCompra;
              }
            );
          } else {
            state.ordenesDeCompra = [];
          }
        }
      )
      .addCase(fetchOrdenesDeCompraByFiltroId.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      });
  },
});

export default ordenDeCompraSlice.reducer;
