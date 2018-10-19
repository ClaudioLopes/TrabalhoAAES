package state;

import controler.Memento;
import funcionario.Administrador;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import model.Funcionario;

/**
 *
 * @author claudio
 */
public class Pedido  extends Observable{
    private PedidoEstado estado;
    private Funcionario funcionarioResponsavel;
    private ArrayList<Memento> estadoSalvo = new ArrayList();

    public Pedido() {
        funcionarioResponsavel = new Administrador("Cozinheiro");
    }

    public PedidoEstado getPedidoEstado() {
        return estado;
    }

    public void setPedidoEstado(PedidoEstado estado) {
        this.estado = estado;
        funcionarioResponsavel.responsavelPedido(estado);
        estadoSalvo.add(saveToMemento(estado));
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
    
    public Memento saveToMemento(PedidoEstado estado){
        return new Memento(estado);
    }
    
    public void restoreFromMemento(Memento memento){
        estado = memento.getEstadoSalvo();
    }
    
    public void imprimiMemento(){
        for(Iterator i = estadoSalvo.iterator();i.hasNext();){
            System.out.println(i.next());
        }
    }
}
