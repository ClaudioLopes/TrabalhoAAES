package funcionario;

import State.PedidoEstadoConfirmado;
import State.PedidoEstadoEmEntrega;
import model.Funcionario;

/**
 *
 * @author claudio
 */
public class Administrador extends Funcionario{
    
    public String responsavel(){
        return "Administrador";
    }

    public Administrador(String superior) {
        setResponsavel(new PedidoEstadoConfirmado());
        setFuncaoSuperior(superior);
    }
}
