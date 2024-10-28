import React from "react";
import BasicModal from "../../components/modal/Modal";
import PurchaseOrderList from "../../components/list/PurchaseOrderList";
import useAuthContext from "../../hooks/AuthContext";
import PurchaseOrderFilter from "../../components/filter/PurchaseOrderFilter";
import "./css/PagesStyle.css";
import BotoneraFilter from "../../components/filter/BotoneraFilter";

const PurchaseOrder: React.FC = () => {
  const { rol } = useAuthContext();
  return (
    <div>
      {rol == "user" && (
        <BasicModal
          titulo="Agregar orden compra"
          proveniencia="ordenDeCompra"
        />
      )}
      <BotoneraFilter />
      <div className="page">
        <PurchaseOrderFilter modal={false} />
        <PurchaseOrderList />
      </div>
    </div>
  );
};

export default PurchaseOrder;
