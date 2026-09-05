package Filtros;

import Modelo.Pedido;

public interface Filtro {
    Pedido procesar (Pedido pedido);
}
