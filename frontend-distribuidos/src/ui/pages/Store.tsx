import StoreFilter from "../../components/filter/StoreFilter";
import StoreList from "../../components/list/StoreList";
import "./css/PagesStyle.css";

const Store: React.FC = () => {
  return (
    <div className="page">
      <StoreFilter />
      <StoreList />
    </div>
  );
};

export default Store;
