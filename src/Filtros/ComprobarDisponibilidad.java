package Filtros;

import Modelo.Estado;
import Modelo.Pedido;
import Modelo.Producto;

public class ComprobarDisponibilidad implements Filtro{
    @Override
    public Pedido procesar(Pedido pedido) {
        if (pedido.getEstado().esError()){
            return pedido;
        }
        for (Producto producto: pedido.getProductos()){
            if (producto.getCantidad() > producto.getExistencias()){
                pedido.setEstado(Estado.ERROR_EXISTENCIA);
                return pedido;
            }
        }
        pedido.setEstado(Estado.PRODUCTOS_DISPONIBLES);
        return pedido;
    }
}
