import React from "react";
import { useFilterContext } from "../../hooks/FilterContext";
import { useOrdenDeCompraContext } from "../../hooks/PurchaseOrderContext";

const BotoneraFilter: React.FC = () => {
  const { filtros } = useFilterContext();
  const { traerOrdenesPorFiltroID } = useOrdenDeCompraContext();

  const handleSearch = (id: number) => {
    traerOrdenesPorFiltroID(id);
  };

  return (
    <div>
      {filtros.map(
        (filtro) =>
          filtro.habilitado && (
            <button
              type="button"
              className="save-button"
              onClick={() => handleSearch(filtro.id)}
            >
              {filtro.nombre}
            </button>
          )
      )}
    </div>
  );
};

export default BotoneraFilter;
