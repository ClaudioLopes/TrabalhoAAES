/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionario;

import State.PedidoEstadoEmEntrega;
import model.Funcionario;

/**
 *
 * @author claudio
 */
public class Entregador extends Funcionario{
    
    public String responsavel(){
        return "Entregador";
    }

    public Entregador(String superior) {
        setResponsavel(new PedidoEstadoEmEntrega());
        setFuncaoSuperior(superior);
    }
}
