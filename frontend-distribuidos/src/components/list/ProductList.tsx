import React, { useEffect, useState } from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { useProductoEnTiendaContext } from "../../hooks/ProductContext";
import BasicModal from "../modal/Modal";
import useAuthContext from "../../hooks/AuthContext";
import { useUserContext } from "../../hooks/UserContext";
import { ProductoEnTienda } from "../../redux/types";

const ProductLis: React.FC = () => {
  const { productosEnTienda, filter_Productos_By_Tienda } =
    useProductoEnTiendaContext();

  const { users } = useUserContext();
  const { rol, id } = useAuthContext();
  const [filteredProducts, setFilteredProducts] = useState<ProductoEnTienda[]>(
    []
  );

  useEffect(() => {
    if (rol === "user") {
      const currentUser = users.find((user) => user.id === id);
      if (currentUser && currentUser.tiendaID) {
        const productosFiltrados = filter_Productos_By_Tienda(
          currentUser.tiendaID
        );
        setFilteredProducts(productosFiltrados);
      } else {
        setFilteredProducts([]);
        console.warn(
          "Usuario no tiene una tienda asociada o no fue encontrado."
        );
      }
    } else if (rol === "admin") {
      setFilteredProducts(productosEnTienda);
    }
  }, [rol, id, productosEnTienda, filter_Productos_By_Tienda]);

  return (
    <div>
      {rol === "admin" && (
        <BasicModal proveniencia="producto" titulo="Agregar" />
      )}
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>ID</TableCell>
              <TableCell>
                código <br /> producto
              </TableCell>
              <TableCell>nombre</TableCell>
              <TableCell>talle</TableCell>
              <TableCell>color</TableCell>
              <TableCell>stock</TableCell>
              <TableCell>tiendaID</TableCell>
              <TableCell>acciones</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {filteredProducts.map((product) => (
              <TableRow
                key={product.id}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell scope="row">{product.id}</TableCell>
                <TableCell scope="row">{product.producto.codigo}</TableCell>
                <TableCell scope="row">{product.producto.nombre}</TableCell>
                <TableCell>{product.talle}</TableCell>
                <TableCell scope="row">{product.color}</TableCell>
                <TableCell scope="row">{product.stock}</TableCell>
                <TableCell scope="row">{product.tienda?.id}</TableCell>
                <TableCell>
                  <BasicModal
                    titulo="Actualizar"
                    proveniencia="producto"
                    producto={product}
                  />
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );
};

export default ProductLis;
