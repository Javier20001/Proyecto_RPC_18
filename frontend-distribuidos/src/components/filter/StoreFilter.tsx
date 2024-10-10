import { TextField, Button } from "@mui/material";
import { ChangeEvent, useState } from "react";
import { useStoreContext } from "../../hooks/StoreContext";

const StoreFilter: React.FC = () => {
  const {
    fetch_all,
    find_by_codigo,
    fetch_habilitadas,
    filter_no_habilitadas,
  } = useStoreContext();
  const [codigo, setCodigo] = useState<string>("");

  const handleInputChange = (event: ChangeEvent<HTMLInputElement>) => {
    const { value } = event.target;
    setCodigo(value);
  };

  const handleSearchByCodigo = (event: React.FormEvent) => {
    event.preventDefault();
    if (codigo) {
      find_by_codigo(codigo);
    } else {
      fetch_all();
    }
    setCodigo("");
  };

  const filterHabilitadas = (event: React.FormEvent) => {
    event.preventDefault();
    fetch_habilitadas();
  };

  const filterNoHabilitadas = () => {
    filter_no_habilitadas();
  };

  return (
    <div className="formFilter">
      <form onSubmit={handleSearchByCodigo} className="form-container">
        <TextField
          fullWidth
          label="Buscar por Código"
          name="codigo"
          value={codigo}
          onChange={handleInputChange}
          margin="normal"
        />
        <button type="submit" className="search-button">
          Buscar tienda
        </button>
      </form>

      <div className="filter-buttons">
        <Button
          variant="contained"
          color="primary"
          onClick={filterHabilitadas}
          className="filter-button"
        >
          Ver Tiendas Habilitadas
        </Button>

        <Button
          variant="contained"
          color="secondary"
          onClick={filterNoHabilitadas}
          className="filter-button"
        >
          Ver Tiendas No Habilitadas
        </Button>
      </div>
    </div>
  );
};

export default StoreFilter;
