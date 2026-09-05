package Filtros;

import Modelo.Estado;
import Modelo.Pedido;

public class VerificarFraude implements Filtro{
    private static final double LIMITE = 5000.0;
    @Override
    public Pedido procesar(Pedido pedido) {
        if (pedido.getEstado().esError()){
            return pedido;
        }
        if (pedido.getSubtotal() > LIMITE){
            pedido.setEstado(Estado.PENDIENTE_REVISION);
            return pedido;
        }
        pedido.setEstado(Estado.FRAUDE_REVISADO);
        return pedido;
    }
}
