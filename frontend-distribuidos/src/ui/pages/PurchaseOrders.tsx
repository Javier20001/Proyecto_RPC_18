import React from "react";
import BasicModal from "../../components/modal/Modal";
import PurchaseOrderList from "../../components/list/PurchaseOrderList";

const PurchaseOrder: React.FC = () => {
  return (
    <div>
      <BasicModal titulo="Agregar orden compra" proveniencia="ordenDeCompra" />
      <PurchaseOrderList />
    </div>
  );
};

export default PurchaseOrder;
