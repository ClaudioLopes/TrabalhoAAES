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
public interface PedidoEstado {
    public void confirmar(Pedido p);
    public void emProducao(Pedido p);
    public void pronto(Pedido p);
    public void emEntrega(Pedido p);
    public void entrege(Pedido p);
    public String getEstado();
}
