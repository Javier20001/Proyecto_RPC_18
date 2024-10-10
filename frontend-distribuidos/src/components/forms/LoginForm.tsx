import React, { useState } from "react";

import { LoginDTO } from "../../redux/types";
import InputField from "../input/InputField";

interface LoginFormProps {
  onSubmit: (values: LoginDTO) => void;
}

const LoginForm: React.FC<LoginFormProps> = ({ onSubmit }) => {
  const [values, setValues] = useState<LoginDTO>({
    username: "",
    password: "",
  });
  const [errors, setErrors] = useState<{
    username?: string;
    password?: string;
  }>({});

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setValues({ ...values, [e.target.name]: e.target.value });
  };

  const validate = () => {
    let tempErrors: { username?: string; password?: string } = {};
    if (!values.username) tempErrors.username = "Username is required";
    if (!values.password) tempErrors.password = "Password is required";
    setErrors(tempErrors);
    return Object.keys(tempErrors).length === 0;
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (validate()) {
      onSubmit(values);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <InputField
        label="Username"
        name="username"
        type="text"
        value={values.username}
        handleChange={handleChange}
        error={errors.username}
      />
      <InputField
        label="Password"
        name="password"
        type="password"
        value={values.password}
        handleChange={handleChange}
        error={errors.password}
      />
      <button type="submit">Login</button>
    </form>
  );
};

export default LoginForm;
