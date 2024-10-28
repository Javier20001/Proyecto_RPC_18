import React from "react";
import LoginForm from "../../components/forms/LoginForm";
import axios from "axios";
import { LoginDTO, LoginResponse } from "../../redux/types";
import { useNavigate } from "react-router-dom";
import useAuthContext from "../../hooks/AuthContext";

const LoginPage: React.FC = () => {
  const navigate = useNavigate();
  const { login } = useAuthContext();

  const handleLogin = async (values: LoginDTO) => {
    try {
      const response = await axios.post<LoginResponse>(
        "http://127.0.0.1:8081/login",
        values
      );

      localStorage.setItem("token", response.data.role);
      localStorage.setItem("idTienda", String(response.data.idTienda));
      const token = response.data.role;
      const id = response.data.id;
      const idTienda = response.data.idTienda;
      login(token, id, idTienda);
      navigate("/home");
    } catch (error) {
      console.error("Error during login:", error);
      alert("Login failed. Please try again.");
    }
  };

  return (
    <div>
      <h1>Login</h1>
      <LoginForm onSubmit={handleLogin} />
    </div>
  );
};

export default LoginPage;
