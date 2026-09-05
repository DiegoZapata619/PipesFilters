package Filtros;

import Modelo.Estado;
import Modelo.Pedido;

public class AplicarDescuento implements Filtro{
    @Override
    public Pedido procesar(Pedido pedido) {
        if (pedido.getEstado().esError()) return pedido;
        double descuento = 0.0;
        if (pedido.getSubtotal() >= 1000.0){
            descuento = pedido.getSubtotal() * 0.10;
        }
        pedido.setDescuento(descuento);
        pedido.setEstado(Estado.DESCUENTO_APLICADO);
        return pedido;

    }
}
