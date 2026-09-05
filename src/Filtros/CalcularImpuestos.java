package Filtros;

import Modelo.Estado;
import Modelo.Pedido;

public class CalcularImpuestos implements Filtro{
   private static final double IVA = 0.16;
    @Override
    public Pedido procesar(Pedido pedido) {
        if (pedido.getEstado().esError()){
            return pedido;
        }
        double precioBase = pedido.getSubtotal() - pedido.getDescuento();
        double impuestos = precioBase * IVA;
        pedido.setImpuestos(impuestos);
        pedido.setTotal(precioBase + impuestos);
        pedido.setEstado(Estado.IMPUESTOS_APLICADOS);
        return pedido;
    }
}
