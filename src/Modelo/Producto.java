package Modelo;

public class Producto {
    private String nombre;
    private int cantidad;
    private int existencias;
    private double precio;


    public Producto(String nombre, int existencias, int cantidad, double precio) {
        this.nombre = nombre;
        this.existencias = existencias;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getExistencias() {
        return existencias;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString(){
        return nombre + "\n"
                + "|$" + precio
                + "Cantidad: " + cantidad
                + "Existencias: " + existencias;

    }
}
