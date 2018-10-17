/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionario;

import State.PedidoEstadoEmEntrega;
import State.PedidoEstadoEmProdução;
import model.Funcionario;

/**
 *
 * @author claudio
 */
public class Cozinheiro extends Funcionario{
    
    public String responsavel(){
        return "Cozinheiro";
    }

    public Cozinheiro (String superior) {
        setResponsavel(new PedidoEstadoEmProdução());
        setFuncaoSuperior(superior);
    }
}
