import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import { Link as RouterLink } from "react-router-dom";

function NavBar() {
  return (
    <AppBar position="static">
      <Toolbar>
        <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
          Stokearte
        </Typography>
        <Button color="inherit" component={RouterLink} to="/Store">
          Tiendas
        </Button>
        <Button color="inherit" component={RouterLink} to="/User">
          Usuarios
        </Button>
        <Button color="inherit" component={RouterLink} to="/Products">
          Productos
        </Button>
        <Button color="inherit" component={RouterLink} to="/">
          Home
        </Button>
      </Toolbar>
    </AppBar>
  );
}

export default NavBar;
