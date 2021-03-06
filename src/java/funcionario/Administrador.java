package funcionario;

import state.PedidoEstadoConfirmado;
import state.PedidoEstadoEmEntrega;
import model.Funcionario;
import persistence.PedidoDAO;
import state.Pedido;
import state.PedidoEstadoEmProdução;

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
    
    public void atualizarPedido(Pedido pedido){
        pedido.setPedidoEstado(new PedidoEstadoEmProdução());
    }
}
