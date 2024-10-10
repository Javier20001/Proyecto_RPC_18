import { createSlice, createAsyncThunk, PayloadAction } from "@reduxjs/toolkit";
import axios from "axios";
import { handleAxiosError } from "../../Errors/HandlerAxiosError";
import { User, UserDTO } from "../types";

interface UsersState {
  users: User[];
  status: "idle" | "loading" | "succeeded" | "failed";
  error: string | null;
}

const initialState: UsersState = {
  users: [],
  status: "idle",
  error: null,
};

export const fetchUsers = createAsyncThunk("users/fetchUsers", async () => {
  const response = await axios.get<User[]>("http://localhost:8081/usuarios");
  return response.data;
});

export const addUser = createAsyncThunk(
  "user/addUser",
  async (userDTO: UserDTO, { rejectWithValue }) => {
    try {
      const response = await axios.post<User>(
        "http://127.0.0.1:8081/usuarios",
        userDTO
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al agregar el usuario"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

export const updateUser = createAsyncThunk(
  "user/updateUser",
  async (
    { userDTO, id }: { userDTO: UserDTO; id: number },
    { rejectWithValue }
  ) => {
    try {
      const response = await axios.put<User>(
        `http://localhost:8081/usuarios/${id}`,
        userDTO
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al actualizar el usuario"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

export const findUserByUsername = createAsyncThunk(
  "user/findUserByUsername",
  async (username: string, { rejectWithValue }) => {
    try {
      const response = await axios.get<User>(
        `http://localhost:8081/usuarios/username/${username}`
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al buscar usuario por nombre de usuario"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

export const findUsersByTienda = createAsyncThunk(
  "users/findUsersByTienda",
  async (tienda_id: number, { rejectWithValue }) => {
    try {
      const response = await axios.get<User[]>(
        `http://localhost:8081/usuarios/tienda/${tienda_id}`
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al buscar usuarios por tienda"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

export const deleteUser = createAsyncThunk(
  "user/disableUser",
  async (userId: number, { rejectWithValue }) => {
    try {
      const response = await axios.delete<User>(
        `http://localhost:8081/usuarios/${userId}/disable`
      );
      return response.data;
    } catch (error: unknown) {
      const errorMessage = handleAxiosError(
        error,
        "Error al deshabilitar el usuario"
      );
      return rejectWithValue(errorMessage);
    }
  }
);

const userSlice = createSlice({
  name: "users",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      .addCase(fetchUsers.pending, (state) => {
        state.status = "loading";
      })
      .addCase(fetchUsers.fulfilled, (state, action: PayloadAction<User[]>) => {
        state.status = "succeeded";
        state.users = action.payload;
      })
      .addCase(fetchUsers.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.error.message || "Algo salió mal";
      })

      .addCase(addUser.pending, (state) => {
        state.status = "loading";
      })
      .addCase(addUser.fulfilled, (state, action: PayloadAction<User>) => {
        state.status = "succeeded";
        state.users.push(action.payload);
      })
      .addCase(addUser.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })
      .addCase(updateUser.pending, (state) => {
        state.status = "loading";
      })
      .addCase(updateUser.fulfilled, (state, action: PayloadAction<User>) => {
        state.status = "succeeded";
        const index = state.users.findIndex(
          (user) => user.id === action.payload.id
        );
        if (index !== -1) {
          state.users[index] = action.payload;
        }
      })
      .addCase(updateUser.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })

      .addCase(deleteUser.pending, (state) => {
        state.status = "loading";
      })
      .addCase(deleteUser.fulfilled, (state, action: PayloadAction<number>) => {
        state.status = "succeeded";
        state.users = state.users.filter((user) => user.id !== action.payload);
      })
      .addCase(deleteUser.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.error.message || "Algo salió mal";
      })
      .addCase(findUserByUsername.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        findUserByUsername.fulfilled,
        (state, action: PayloadAction<User>) => {
          state.status = "succeeded";
          state.users = [action.payload]; // Puede ser un solo usuario
        }
      )
      .addCase(findUserByUsername.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      })

      .addCase(findUsersByTienda.pending, (state) => {
        state.status = "loading";
      })
      .addCase(
        findUsersByTienda.fulfilled,
        (state, action: PayloadAction<User[]>) => {
          state.status = "succeeded";
          state.users = action.payload;
        }
      )
      .addCase(findUsersByTienda.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.payload as string;
      });
  },
});

export default userSlice.reducer;
