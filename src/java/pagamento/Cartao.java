package pagamento;

/**
 *
 * @author claudio
 */
public class Cartao extends FormaPagamento{
    
    public int getDesconto() {
        return 5;
    }

    @Override
    public String getNome() {
        return "Cartão";
    }

    public Cartao() {
    }
}
