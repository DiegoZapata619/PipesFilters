package Filtros;

import Modelo.Estado;
import Modelo.Pedido;

public class ConfirmarPedido implements Filtro{
    @Override
    public Pedido procesar(Pedido pedido) {
        if (pedido.getEstado().esError()){
            return pedido;
        }
        if (pedido.getEstado() == Estado.PENDIENTE_REVISION){
            return pedido;
        }

        pedido.setEstado(Estado.CONFIRMADO);
        return pedido;
    }
}
