import grpc
import tienda_pb2
import tienda_pb2_grpc

# Crear la conexión con el servidor gRPC
def run():
    with grpc.insecure_channel('localhost:9090') as channel:
        stub = tienda_pb2_grpc.TiendaServiceStub(channel)

        # FindAll - Obtener todas las tiendas
        print("FindAll")
        response = stub.FindAll(tienda_pb2.TiendaEmpty())
        for tienda in response.tienda:
            print(f"Tienda ID: {tienda.id}, Código: {tienda.codigo}, Habilitada: {tienda.habilitada}")

        
        # FindById - Obtener tienda por ID
        print("\nFindById")
        response = stub.FindById(tienda_pb2.Tienda(id=3))
        print(f"Tienda ID: {response.id}, Código: {response.codigo}, Provincia: {response.provincia}, Ciudad: {response.ciudad}")
        
        # FindByCodigo - Obtener tienda por código
        print("\nFindByCodigo")
        response = stub.FindByCodigo(tienda_pb2.Tienda(codigo="TIENDA001MOD"))
        print(f"Tienda ID: {response.id}, Código: {response.codigo}, Provincia: {response.provincia}, Ciudad: {response.ciudad}")
        
        # FindAllTiendasHabilitadas - Obtener todas las tiendas habilitadas
        print("\nFindAllTiendasHabilitadas")
        response = stub.FindAllTiendasHabilitadas(tienda_pb2.TiendaEmpty())
        for tienda in response.tienda:
            print(f"Tienda ID: {tienda.id}, Código: {tienda.codigo}, Habilitada: {tienda.habilitada}")

        # AddTienda - Agregar una nueva tienda
        print("\nAddTienda")
        new_tienda = tienda_pb2.Tienda(
            codigo="TIENDA003",
            provincia="Buenos Aires2",
            ciudad="La Plata2",
            direccion="Calle Falsa 1234",
            habilitada=False
        )
        response = stub.AddTienda(new_tienda)
        print(f"Nueva Tienda Agregada ID: {response.id}, Código: {response.codigo}")

        # ModifyTienda - Modificar una tienda existente
        print("\nModifyTienda")
        modified_tienda = tienda_pb2.Tienda(
            id=3,  # El ID de la tienda que deseas modificar
            codigo="TIENDA001MOD",
            provincia="Buenos Aires",
            ciudad="Bahía Blanca",
            direccion="Calle Verdadera 456",
            habilitada=True
        )
        response = stub.ModifyTienda(modified_tienda)
        print(f"Tienda Modificada ID: {response.id}, Código: {response.codigo}")
        
        # DisableTienda - Deshabilitar una tienda
        print("\nDisableTienda")
        tienda_to_disable = tienda_pb2.Tienda(id=3)
        response = stub.DisableTienda(tienda_to_disable)
        print(f"Tienda Deshabilitada ID: {response.id}, Habilitada: {response.habilitada}")
        

if __name__ == "__main__":
    run()
