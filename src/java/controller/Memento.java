package controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.MementoDAO;
import state.Pedido;
import state.PedidoEstado;

/**
 *
 * @author claudio
 */
public class Memento {
    private PedidoEstado estado;
    private Pedido pedido;
    
    public PedidoEstado getEstadoSalvo(){
        return estado;
    }
    
    public String toString(){
        return estado.getEstado();
    }

    public Memento(PedidoEstado estado) {
        this.estado = estado;
    }

    public Memento(Pedido pedido) {
        this.pedido = pedido;
        if(pedido.getId() != null) {
            try {
                MementoDAO.getInstance().save(pedido);
            } catch (SQLException ex) {
                Logger.getLogger(Memento.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Memento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
