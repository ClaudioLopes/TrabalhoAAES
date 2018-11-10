package state;

/**
 *
 * @author claudio
 */
public class PedidoEstadoEntrege implements PedidoEstado{

    public void confirmar(Pedido p) {
        System.out.println("Pedido entrege");
    }

    public void emProducao(Pedido p) {
        System.out.println("Pedido entrege");
    }

    public void pronto(Pedido p) {
        System.out.println("Pedido entrege");
    }

    public void emEntrega(Pedido p) {
        System.out.println("Pedido entrege");
    }

    public void entrege(Pedido p) {
        System.out.println("Pedido entrege");
    }

    public String getEstado() {
        return "Entregue";
    }
    
}
