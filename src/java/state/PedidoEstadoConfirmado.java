/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

/**
 *
 * @author claudio
 */
public class PedidoEstadoConfirmado implements PedidoEstado{

    public void confirmar(Pedido p) {
        System.out.println("Pedido já confirmado");
    }

    public void emProducao(Pedido p) {
        p.setPedidoEstado(new PedidoEstadoEmProdução());
    }

    public void pronto(Pedido p) {
        p.setPedidoEstado(new PedidoEstadoPronto());
    }

    public void emEntrega(Pedido p) {
        System.out.println("Pedido ainda não está pronto");
    }

    public void entrege(Pedido p) {
        p.setPedidoEstado(new PedidoEstadoEntrege());
    }

    public String getEstado() {
        return "Confirmado";
    }
    
}
