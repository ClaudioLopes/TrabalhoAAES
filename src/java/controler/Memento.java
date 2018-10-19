package controler;

import state.PedidoEstado;

/**
 *
 * @author claudio
 */
public class Memento {
    private PedidoEstado estado;
    
    public PedidoEstado getEstadoSalvo(){
        return estado;
    }
    
    public String toString(){
        return estado.getEstado();
    }

    public Memento(PedidoEstado estado) {
        this.estado = estado;
    }
}
