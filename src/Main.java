import Filtros.*;
import Modelo.Estado;
import Modelo.Pedido;
import Modelo.Producto;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Filtro> pipeline = List.of(new ValidarDatos(),
                new ComprobarDisponibilidad(),
                new CalcularSubtotal(),
                new VerificarFraude(),
                new AplicarDescuento(),
                new CalcularImpuestos(),
                new ConfirmarPedido());

        Pedido pedidoPrueba = new Pedido();
        pedidoPrueba.setCliente("Juan Pérez");
        pedidoPrueba.setEstado(Estado.NUEVO);
        pedidoPrueba.setProductos(List.of(
                new Producto("Teclado", 20, 2, 200.0),
                new Producto("Mouse",15,4,100.0)
        ));

        System.out.println(pedidoPrueba);

        for (Filtro filtro: pipeline){
            pedidoPrueba = filtro.procesar(pedidoPrueba);
            //En lugar del nombre de clase, podría ser "Filtro i: Estado"
            System.out.println(filtro.getClass().getSimpleName() + " -> " + pedidoPrueba.getEstado());

            if (pedidoPrueba.getEstado().esError()){
                break;
            }

        }

        System.out.println(pedidoPrueba);

    }
}