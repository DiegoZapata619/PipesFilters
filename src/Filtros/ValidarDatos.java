package Filtros;

import Modelo.Estado;
import Modelo.Pedido;

public class ValidarDatos implements Filtro {
    @Override
    public Pedido procesar(Pedido pedido) {
        if (pedido.getCliente().isEmpty() || pedido.getCliente().isBlank() || pedido.getCliente()==null||
                pedido.getProductos() == null || pedido.getProductos().isEmpty()){
            pedido.setEstado(Estado.ERROR_DATOS);
            return pedido;
        }
        pedido.setEstado(Estado.DATOS_VALIDADOS);
        return pedido;
    }
}
