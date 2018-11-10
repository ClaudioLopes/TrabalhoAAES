/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionario;

import state.PedidoEstadoEmEntrega;
import model.Funcionario;
import state.Pedido;
import state.PedidoEstadoConfirmado;
import state.PedidoEstadoEntrege;

/**
 *
 * @author claudio
 */
public class Entregador extends Funcionario{
    
    public String responsavel(){
        return "Entregador";
    }
    
    public Entregador() {
        setResponsavel(new PedidoEstadoEmEntrega());
        setFuncao(responsavel());
    }

    public Entregador(String superior) {
        setResponsavel(new PedidoEstadoEmEntrega());
        setFuncionarioSuperior(superior);
    }
    
    public void atualizarPedido(Pedido pedido){
        pedido.setPedidoEstado(new PedidoEstadoEntrege());
    }
}
