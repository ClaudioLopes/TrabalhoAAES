package State;

/**
 *
 * @author claudio
 */
public class PedidoEstadoPronto implements PedidoEstado{

    public void confirmar(Pedido p) {
        p.setPedidoEstado(new PedidoEstadoConfirmado());
    }

    public void emProducao(Pedido p) {
        p.setPedidoEstado(new PedidoEstadoEmProdução());
    }
    
    public void pronto(Pedido p) {
        System.out.println("Pedido Pronto");
    }

    public void emEntrega(Pedido p) {
        p.setPedidoEstado(new PedidoEstadoEmEntrega());
    }

    public void entrege(Pedido p) {
        p.setPedidoEstado(new PedidoEstadoEntrege());
    }

    public String getEstado() {
        return "Pronto";
    }
    
}
