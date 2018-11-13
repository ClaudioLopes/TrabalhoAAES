package pagamento;

import state.Pedido;
import strategy.Produto;

/**
 *
 * @author claudio
 */
public abstract class FormaPagamento {
    
    public abstract int getDesconto();
    public abstract String getNome();
    public abstract String getNomeSA();
    
    public void gerarBoleto(Pedido pedido){
        float valorPedido = 0;
        for (Produto produto : pedido.getProduto()) {
            valorPedido = produto.getValor() - getDesconto();
        }
        System.out.println("Valor: " + valorPedido);
    }
}
