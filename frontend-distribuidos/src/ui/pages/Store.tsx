import StoreList from "../../components/list/StoreList";
import { StoreProvider } from "../../hooks/StoreContext";

const Store: React.FC = () => {
  return (
    <div>
      <StoreProvider>
        <StoreList />
      </StoreProvider>
    </div>
  );
};

export default Store;
