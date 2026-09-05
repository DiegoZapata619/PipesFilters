package Filtros;

import Modelo.Estado;
import Modelo.Pedido;
import Modelo.Producto;

public class CalcularSubtotal implements Filtro{
    @Override
    public Pedido procesar(Pedido pedido) {
        if (pedido.getEstado().esError()) {
            return pedido;
        }
        double subtotal = 0.0;
        //PODRIA ser sustituido con Stream y map()
        for (Producto producto: pedido.getProductos()){
            subtotal += producto.getCantidad() * producto.getPrecio();
        }
        pedido.setSubtotal(subtotal);
        pedido.setEstado(Estado.SUBTOTAL_CALCULADO);
        return pedido;
    }
}
