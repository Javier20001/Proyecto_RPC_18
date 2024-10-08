import { createSlice, createAsyncThunk, PayloadAction } from "@reduxjs/toolkit";
import axios from "axios";
import { handleAxiosError } from "../../Errors/HandlerAxiosError";
import { User, UserDTO } from "../types"; // Asegúrate de definir estos tipos en tu archivo de tipos.

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

// Traer todos los usuarios
export const fetchUsers = createAsyncThunk("users/fetchUsers", async () => {
  const response = await axios.get<User[]>("http://localhost:8081/usuarios");
  return response.data;
});

// Agregar usuario
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

// Actualizar usuario
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

// Eliminar usuario
export const deleteUser = createAsyncThunk(
  "user/deleteUser",
  async (userId: number) => {
    await axios.delete(`http://localhost:8081/usuarios/${userId}`);
    return userId;
  }
);

const userSlice = createSlice({
  name: "users",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      // Casos para traer todos los usuarios
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

      // Casos para agregar usuario
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

      // Casos para actualizar usuario
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

      // Casos para eliminar usuario
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
      });
  },
});

export default userSlice.reducer;
