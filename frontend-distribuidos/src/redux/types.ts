// Interface para la tabla User
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
  productos?: ProductoEnTienda[]; // Relación con productos
}

// Interface para la tabla Producto
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
}
