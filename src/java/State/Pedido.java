package State;

import funcionario.Administrador;
import java.util.Observable;
import model.Funcionario;

/**
 *
 * @author claudio
 */
public class Pedido  extends Observable{
    private PedidoEstado estado;
    private Funcionario funcionarioResponsavel;

    public Pedido() {
        funcionarioResponsavel = new Administrador("Cozinheiro");
    }

    public PedidoEstado getPedidoEstado() {
        return estado;
    }

    public void setPedidoEstado(PedidoEstado estado) {
        this.estado = estado;
        funcionarioResponsavel.responsavelPedido(estado);
        setChanged();
        notifyObservers();
    }
    
    public void confirmar(){
        estado.confirmar(this);
    }
    
    public void emProducao(){
        estado.emProducao(this);
    }
    
    public void pronto(){
        estado.pronto(this);
    }
    
    public void emEntrega(){
        estado.emEntrega(this);
    }
    
    public void entrege(){
        estado.entrege(this);
    }
    
    
}
