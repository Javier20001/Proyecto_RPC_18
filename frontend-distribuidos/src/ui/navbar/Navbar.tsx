import React from "react";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import { Link as RouterLink } from "react-router-dom";
import useAuthContext from "../../hooks/AuthContext";

const NavBar: React.FC = () => {
  const { isAuthenticated, logout, rol } = useAuthContext();

  return (
    <AppBar position="static">
      <Toolbar>
        <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
          Stokearte
        </Typography>
        {isAuthenticated ? (
          <>
            {rol === "admin" && (
              <>
                <Button color="inherit" component={RouterLink} to="/Store">
                  Tiendas
                </Button>
                <Button color="inherit" component={RouterLink} to="/User">
                  Usuarios
                </Button>
                <Button color="inherit" component={RouterLink} to="/News">
                  Novedades
                </Button>
              </>
            )}
            <Button color="inherit" component={RouterLink} to="/Products">
              Productos
            </Button>
            <Button color="inherit" component={RouterLink} to="/home">
              Home
            </Button>
            <Button color="inherit" component={RouterLink} to="/PurchaseOrder">
              PurchaseOrder
            </Button>
            <Button color="inherit" onClick={logout}>
              Logout
            </Button>
          </>
        ) : (
          <Button color="inherit" component={RouterLink} to="/">
            Login
          </Button>
        )}
      </Toolbar>
    </AppBar>
  );
};

export default NavBar;
