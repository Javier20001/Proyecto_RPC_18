import React, { useContext } from "react";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import { Link as RouterLink } from "react-router-dom";
import { AuthContext } from "../../hooks/AuthContext";

const NavBar: React.FC = () => {
  const authContext = useContext(AuthContext);

  if (!authContext) {
    return null;
  }

  const { isAuthenticated, logout, rol } = authContext;

  const userRole = rol;

  return (
    <AppBar position="static">
      <Toolbar>
        <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
          Stokearte
        </Typography>
        {isAuthenticated ? (
          <>
            {userRole === "admin" && (
              <>
                <Button color="inherit" component={RouterLink} to="/Store">
                  Tiendas
                </Button>
                <Button color="inherit" component={RouterLink} to="/User">
                  Usuarios
                </Button>
              </>
            )}
            <Button color="inherit" component={RouterLink} to="/Products">
              Productos
            </Button>
            <Button color="inherit" component={RouterLink} to="/home">
              Home
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
