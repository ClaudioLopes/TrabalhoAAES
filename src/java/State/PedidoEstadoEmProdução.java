/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

/**
 *
 * @author claudio
 */
public class PedidoEstadoEmProdução implements PedidoEstado{

    public void confirmar(Pedido p) {
        p.setPedidoEstado(new PedidoEstadoConfirmado());
    }

    public void emProducao(Pedido p) {
        System.out.println("Pedido em produção");
    }

    public void pronto(Pedido p) {
        p.setPedidoEstado(new PedidoEstadoPronto());
    }

    public void emEntrega(Pedido p) {
        System.out.println("Pedido em produção");
    }

    public void entrege(Pedido p) {
        System.out.println("Pedido em produção");
    }

    public String getEstado() {
        return "Em Produção";
    }
    
}
