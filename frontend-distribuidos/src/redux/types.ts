export interface User {
  id: number;
  username: string;
  nombre: string;
  apellido: string;
  habilitado: boolean;
  rol: string;
  tiendaID: number;
  password: string;
}

export interface Tienda {
  id: number;
  codigo: string;
  provincia: string;
  ciudad: string;
  direccion: string;
  habilitada: boolean;
  productos?: ProductoEnTienda[];
}

export interface Producto {
  idProducto: number;
  nombre: string;
  codigo: string;
  foto: string;
}

export interface ProductoEnTienda {
  id: number;
  producto: Producto;
  tienda?: Tienda;
  stock: number;
  talle: string;
  color: string;
}

export interface OrdenDeCompraModel {
  id: number;
  estado: string;
  observaciones: string;
  productosEnOC: ProductoEnOCModel[];
  tiendaId: number;
  ordenDeDespachoId: number;
  fechaDeSolicitud: string;
  fechaDeRecepcion: string;
  pausada: boolean;
}

export interface ProductoEnOCModel {
  id: number;
  codigo: string;
  color: string;
  talle: string;
  cantidadSolicitada: number;
}

export interface ProductoNovedades {
  id: number;
  nombre: string;
  codigo: string;
  foto: string;
  talle: string;
  aceptado: boolean;
}

export interface ordenesAgrupadas {
  ordenesAgrupadas: orden[];
}

export interface orden {
  codigoProducto: string;
  estado: string;
  tiendaId: number;
  cantidadTotalPedida: number;
}

export interface FiltroBase {
  //este es para buscar
  codigoProducto?: string;
  fechaInicio?: string;
  fechaFin?: string;
  estado?: string;
  tiendaId?: number | string;
  habilitado?: boolean;
}

export interface Filtro extends FiltroBase {
  //este es para actualizar un filtro
  id: number;
  nombre: string;
}

export interface FiltroUpdate extends FiltroBase {
  filtroId: number;
  nombre: string;
}

export interface FiltroAdd extends FiltroBase {
  //y este es para guardar
  usuarioId: number;
  nombre: string;
}

// DTOS

export interface ProductoDTO {
  nombre: string;
  foto: string;
}

export interface UserDTO {
  username: string;
  password: string;
  nombre: string;
  apellido: string;
}

export interface TiendaDTO {
  codigo: string;
  provincia: string;
  ciudad: string;
  direccion: string;
}

// este sirve para actualziar pero requiere el id a diferencia que para el agregar
export interface ProductoEnTiendaDTO {
  producto_id?: number;
  nombre: string;
  codigo: string;
  foto: string;
  talle: string;
  color: string;
}

export interface AsignarProductoEnTiendaDTO {
  producto_id: number;
  codigo: string;
  foto?: string;
  nombre: string;
  color: string;
  talle: string;
  tienda_id: number;
}

export interface filterProductoTiendaDTO {
  nombre: string;
  codigo: string;
  talle: string;
  color: string;
  tienda_id: number;
}

export interface updatProductStock {
  producto_id: number;
  tienda_id: number;
  stock: number;
  talle: string;
  color: string;
}

export interface LoginDTO {
  username: string;
  password: string;
}

export interface LoginResponse {
  id: number;
  message: string;
  role: string;
  idTienda: number;
}
