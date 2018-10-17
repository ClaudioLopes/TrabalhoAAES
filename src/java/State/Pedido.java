/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import java.util.Observable;

/**
 *
 * @author claudio
 */
public class Pedido  extends Observable{
    private PedidoEstado estado;

    public Pedido() {
    }

    public PedidoEstado getPedidoEstado() {
        return estado;
    }

    public void setPedidoEstado(PedidoEstado estado) {
        this.estado = estado;
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
