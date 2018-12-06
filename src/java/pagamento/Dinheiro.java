package pagamento;

/**
 *
 * @author claudio
 */
public class Dinheiro extends FormaPagamento{
    
    public int getDesconto() {
        return 10;
    }

    @Override
    public String getNome() {
        return "Dinheiro";
    }
    
}
