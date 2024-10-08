import React from "react";

interface InputFieldProps {
  label: string;
  name: string;
  type: string;
  value: string;
  handleChange: (e: React.ChangeEvent<HTMLInputElement>) => void;
  error?: string;
}

const InputField: React.FC<InputFieldProps> = ({
  label,
  name,
  type,
  value,
  handleChange,
  error,
}) => {
  return (
    <div>
      <label htmlFor={name}>{label}</label>
      <input
        id={name}
        name={name}
        type={type}
        value={value}
        onChange={handleChange}
        style={{ borderColor: error ? "red" : "inherit" }}
      />
      {error && <p style={{ color: "red" }}>{error}</p>}
    </div>
  );
};

export default InputField;
