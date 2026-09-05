package Modelo;

import javax.swing.table.TableRowSorter;
import java.util.Enumeration;
import java.util.List;

public class Pedido {
    private String cliente;
    private List<Producto> productos;
    //En vez de double, podría ser BigDecimal
    private double subtotal;
    private double descuento;
    private double impuestos;
    private double total;
    private Estado estado;
    private boolean fraude;

    public Pedido() {
    }

    public Pedido(String cliente, List<Producto> productos, double subtotal) {
        this.cliente = cliente;
        this.productos = productos;
        this.subtotal = subtotal;
        this.descuento = 0.0;
        this.impuestos = 0.0;
        this.total = 0.0;
        fraude = false;
        estado = Estado.NUEVO;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    //Método auxiliar para tener información más descriptiva en el toString()
    public String esFraude(){
        if (fraude){
            return "Revisión por posible fraude";
        }
        return "Libre de Fraude";
    }

    @Override
    public String toString (){
        return """
              Cliente: %s
              Subtotal: $%.2f
              Descuento: $%.2f
              Impuestos: $%.2f
              Total: $%.2f
              Revisión fraude: %s
              Estado: %s
              """.formatted(
                      cliente,subtotal,descuento,impuestos,total,esFraude(),estado);


    }

}
