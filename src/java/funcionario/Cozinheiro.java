/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionario;

import state.PedidoEstadoEmEntrega;
import state.PedidoEstadoEmProdução;
import model.Funcionario;
import state.Pedido;
import state.PedidoEstadoConfirmado;

/**
 *
 * @author claudio
 */
public class Cozinheiro extends Funcionario {

    public String responsavel() {
        return "Cozinheiro";
    }

    public Cozinheiro() {
        setResponsavel(new PedidoEstadoEmProdução());
        setFuncao(responsavel());
        setFuncionarioSuperior("Entregador");
    }

    public Cozinheiro(String superior) {
        setResponsavel(new PedidoEstadoEmProdução());
        setFuncionarioSuperior(superior);
    }

    public void atualizarPedido(Pedido pedido) {
        pedido.setPedidoEstado(new PedidoEstadoEmEntrega());
    }
}
