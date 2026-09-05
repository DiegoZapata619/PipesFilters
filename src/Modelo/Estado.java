package Modelo;

//Estados según el filtro por el que haya pasado. Mejora cómo se ve el flujo de filtros
public enum Estado {
    NUEVO,
    DATOS_VALIDADOS,
    PRODUCTOS_DISPONIBLES,
    SUBTOTAL_CALCULADO,
    FRAUDE_REVISADO,
    DESCUENTO_APLICADO,
    IMPUESTOS_APLICADOS,
    CONFIRMADO,
    ERROR_DATOS,
    ERROR_EXISTENCIA,
    PENDIENTE_REVISION;

    public boolean esError (){
        return this == ERROR_DATOS || this == ERROR_EXISTENCIA;
    }

}
