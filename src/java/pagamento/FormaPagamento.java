package pagamento;

import state.Pedido;

/**
 *
 * @author claudio
 */
public abstract class FormaPagamento {
    
    public abstract int getDesconto();
    
    public void gerarBoleto(Pedido pedido){
        int valorPedido = pedido.getProduto().getValor() - getDesconto();
        System.out.println("Valor: " + valorPedido);
    }
}
